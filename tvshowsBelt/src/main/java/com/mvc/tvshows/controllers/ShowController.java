package com.mvc.tvshows.controllers;


import com.mvc.tvshows.models.Rate;
import com.mvc.tvshows.models.Show;
import com.mvc.tvshows.models.User;
import com.mvc.tvshows.services.Services;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ShowController {

    private final Services service;

    public ShowController(Services service) {
        this.service = service;
    }

    @RequestMapping("/shows/new")
    public String newShow(Model model, @ModelAttribute("show") Show show, HttpSession session, RedirectAttributes r) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            r.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/";
        }
        User u = service.findUserById(userId);
        model.addAttribute("user", u);
        return "newShow.jsp";
    }

    @PostMapping("/shows")
    public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, RedirectAttributes r) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            r.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/";
        }
        if(result.hasErrors()) {
            return "newShow.jsp";
        } else {
            Show s = service.create(show);
            Long newShowId = s.getId();
            return String.format("redirect:/shows/%d", newShowId);
        }
    }

    @RequestMapping("/shows/{id}")
    public String showShow(Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes r, @Valid @ModelAttribute("review") Rate rate, BindingResult result) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            r.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/";
        }
        model.addAttribute("show", service.findOneById(id));
        User u = service.findUserById(userId);
        model.addAttribute("user", u);
        return "displayShow.jsp";
    }

    @RequestMapping("/shows/{id}/edit")
    public String editShow(Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes r) {
        Show s = service.findOneById(id);
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            r.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/";
        } else if(userId != s.getUserTitle().getId()) {
            r.addFlashAttribute("error", "You cannot edit this show!");
            return "redirect:/shows";
        }
        model.addAttribute("show", s);
        return "edit.jsp";
    }

    @RequestMapping("/shows/{id}/update")
    public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult result, @PathVariable("id") Long id, HttpSession session, RedirectAttributes r) {
        Show s = service.findOneById(id);
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            r.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/";
        } else if(userId != s.getUserTitle().getId()) {
            r.addFlashAttribute("error", "You cannot edit this show!");
            return "redirect:/shows";
        }

        if(result.hasErrors()) {
            return "edit.jsp";
        } else {
            service.update(show);
            return String.format("redirect:/shows/%d", id);
        }
    }
    @RequestMapping(value="/shows/{id}", method= RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id, HttpSession session, RedirectAttributes r) {
        Show s = service.findOneById(id);
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            r.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/";
        } else if(userId != s.getUserTitle().getId()) {
            r.addFlashAttribute("error", "You cannot edit this show!");
            return "redirect:/shows";
        }
        service.delete(id);
        return "redirect:/shows";
    }

}
