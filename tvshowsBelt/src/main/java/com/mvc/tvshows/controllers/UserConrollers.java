package com.mvc.tvshows.controllers;

import com.mvc.tvshows.models.Show;
import com.mvc.tvshows.models.User;
import com.mvc.tvshows.services.Services;
import com.mvc.tvshows.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class  UserConrollers {
    private final Services service;
    private final UserValidator userValidator;

    public UserConrollers(Services service, UserValidator userValidator) {
        this.service = service;
        this.userValidator = userValidator;
    }


    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId != null) {
            return "redirect:/shows";
        }
        return "loginRegister.jsp";
    }

    @RequestMapping(value="/users", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "loginRegister.jsp";
        } else {
            User u = service.registerUser(user);
            session.setAttribute("userId",  u.getId());;
            return "redirect:/shows";
        }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
        boolean isAuthenticated = service.authenticateUser(email, password);
        if(isAuthenticated) {
            User u = service.findByEmail(email);
            session.setAttribute("userId", u.getId());
            return "redirect:/shows";
        } else {
            model.addAttribute("error", "Invalid Credentials. Please try again.");
            return "loginRegister.jsp";
        }
    }

    @RequestMapping("/shows")
    public String home(HttpSession session, Model model, RedirectAttributes flash) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You must be logged in to view that page!");
            return "redirect:/login";
        }
        User u = service.findUserById(userId);
        List<Show> shows = service.findAll();
        model.addAttribute("user", u);
        model.addAttribute("shows", shows);
        return "dashboard.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
