package com.mvc.authentication.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mvc.authentication.models.Event;

import com.mvc.authentication.models.Message;
import com.mvc.authentication.models.User;
import com.mvc.authentication.services.UserService;
import com.mvc.authentication.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class Users {
    private final UserService eventService;
    private final UserValidator eventValidator;

    public Users (UserService eventService, UserValidator eventValidator) {
        this.eventService = eventService;
        this.eventValidator = eventValidator;
    }

    @RequestMapping("/")
    public String start (@ModelAttribute("user") User user, HttpSession session) {
        if (session.getAttribute("id")!= null) {
            return "redirect:/events";
        }

        return "start.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
                           HttpSession session) {
        eventValidator.validate(user, result);

        if (result.hasErrors()) {
            return "start.jsp";
        }
        else {
            eventService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/events";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, HttpSession session, RedirectAttributes r) {
        boolean success = eventService.authenticateUser(email, password);

        if (email.length() < 1) {
            r.addFlashAttribute("error", "Email field cannot be blank.");
            return "redirect:/";
        }
        else if (password.length() < 1) {
            r.addFlashAttribute("error", "Please enter your password.");
            return "redirect:/";
        }
        else if (!success) {
            r.addFlashAttribute("error", "Email and password do not match.");
            return "redirect:/";
        }
        else {
            User user = eventService.findByEmail(email);
            Long id = user.getId();
            session.setAttribute("id", id);
            return "redirect:/events";
        }
    }

    @RequestMapping("/events")
    public String home (HttpSession session, Model model) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Long id = (Long) session.getAttribute("id");
        User user = eventService.findUserById(id);
        model.addAttribute("user", user);

        List <Event> events = eventService.allEvents();
        ArrayList <Event> topevents = new ArrayList<Event> ();
        for (int i = 0; i < events.size(); i++) {
            Event top = events.get(i);
            String state = top.getState();
            if (state.equals(user.getState())) {
                topevents.add(top);
            }
        }
        model.addAttribute("topevents", topevents);

        ArrayList <Event> bottomevents = new ArrayList<Event> ();
        for (int i = 0; i < events.size(); i++) {
            Event bottom = events.get(i);
            String state = bottom.getState();
            if (!state.equals(user.getState())) {
                bottomevents.add(bottom);
            }
        }
        model.addAttribute("bottomevents", bottomevents);
        return "home.jsp";
    }

    @RequestMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/events/new")
    public String createEvent (@RequestParam("name") String name, @RequestParam("date") String date,
                               @RequestParam("city") String city, @RequestParam("state") String state, HttpSession session,
                               RedirectAttributes r) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Date newDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d = sdf.format(newDate);

        if (name.length() < 1) {
            r.addFlashAttribute("error", "Please type in the name of the event");
            return "redirect:/events";
        }
        if (date.length() < 1) {
            r.addFlashAttribute("error", "Please select a date for the event");
            return "redirect:/events";
        }
        else if (date.compareTo(d) < 0) {
            r.addFlashAttribute("error", "Event must scheduled after the current date");
            return "redirect:/events";
        }
        else if (city.length() < 1) {
            r.addFlashAttribute("error", "Please type in the location of the event");
            return "redirect:/events";
        }
        else {
            Long id = (Long) session.getAttribute("id");
            User creator = eventService.findUserById(id);
            Event e = new Event();
            e.setName(name);
            e.setDate(date);
            e.setCity(city);
            e.setState(state);
            e.setCreator(creator);
            eventService.createEvent(e);
            return "redirect:/events";
        }
    }

    @RequestMapping("/events/{id}/join")
    public String joinEvent (@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Event event = eventService.findEvent(id);
        Long user_id = (Long) session.getAttribute("id");
        User user = eventService.findUserById(user_id);
        event.getUsers().add(user);
        eventService.createEvent(event);
        return "redirect:/events";
    }

    @RequestMapping("/events/{id}/cancel")
    public String cancelEvent (@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Event event = eventService.findEvent(id);
        Long user_id = (Long) session.getAttribute("id");
        User user = eventService.findUserById(user_id);
        event.getUsers().remove(user);
        eventService.createEvent(event);
        return "redirect:/events";
    }

    @RequestMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Event event = eventService.findEvent(id);
        eventService.deleteEvent(event);
        return "redirect:/events";
    }

    @RequestMapping("/events/{id}/edit")
    public String editEvent (@PathVariable("id") Long id, HttpSession session, Model model) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Long user_id = (Long) session.getAttribute("id");
        User user = eventService.findUserById(user_id);
        Event event = eventService.findEvent(id);
        if (event.getCreator() != user) {
            return "redirect:/events";
        }
        else {
            model.addAttribute("event", event);
            return "edit.jsp";
        }
    }

    @RequestMapping("/events/{id}/edit/process")
    public String editEventProcess (@PathVariable("id") Long id, @RequestParam("name") String name,
                                    @RequestParam("date") String date, @RequestParam("city") String city,
                                    @RequestParam("state") String state, HttpSession session, RedirectAttributes r) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Date newDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d = sdf.format(newDate);

        if (name.length() < 1) {
            r.addFlashAttribute("error", "Please type in the name of the event");
            return "redirect:/events/" + id + "/edit";
        }
        if (date.length() < 1) {
            r.addFlashAttribute("error", "Please select a date for the event");
            return "redirect:/events/" + id + "/edit";
        }
        else if (date.compareTo(d) < 0) {
            r.addFlashAttribute("error", "Event must scheduled after the current date");
            return "redirect:/events/" + id + "/edit";
        }
        else if (city.length() < 1) {
            r.addFlashAttribute("error", "Please type in the location of the event");
            return "redirect:/events/" + id + "/edit";
        }
        else {
            Event e = eventService.findEvent(id);
            e.setName(name);
            e.setDate(date);
            e.setCity(city);
            e.setState(state);
            eventService.createEvent(e);
            return "redirect:/events";
        }
    }

    @RequestMapping("/events/{id}")
    public String showEvent (@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        Event event = eventService.findEvent(id);
        model.addAttribute("event", event);
        List <User> joined = event.getUsers();
        model.addAttribute("joined", joined);
        List <Message> messages = event.getComments();
        model.addAttribute("messages", messages);
        return "show.jsp";
    }

    @RequestMapping("/events/{id}/comment")
    public String commentEvent (@PathVariable("id") Long id,
                                @RequestParam("comment") String comment, HttpSession session, RedirectAttributes r) {
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        if (comment.length() < 5) {
            r.addFlashAttribute("error", "Comment must be at least five characters long.");
            return "redirect:/events/" + id;
        }
        else {
            Message c = new Message();
            c.setComment(comment);
            Event event = eventService.findEvent(id);
            c.setEvent(event);
            Long user_id = (Long) session.getAttribute("id");
            User user = eventService.findUserById(user_id);
            c.setUser(user);
            eventService.createComment(c);
            return "redirect:/events/" + id;
        }
    }
    }

