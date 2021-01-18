package com.codingdojo.java.spring.loginregister.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.java.spring.loginregister.models.User;
import com.codingdojo.java.spring.loginregister.services.UserService;
import com.codingdojo.java.spring.loginregister.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController (UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/")
    public String start (@ModelAttribute("user") User user) {
        return "start.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
                           HttpSession session) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "start.jsp";
        }
        else {
            userService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, HttpSession session, RedirectAttributes r) {
        boolean success = userService.authenticateUser(email, password);

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
            User user = userService.findByEmail(email);
            Long id = user.getId();
            session.setAttribute("id", id);
            return "redirect:/home";
        }
    }

    @RequestMapping("/home")
    public String home (HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("id");
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "home.jsp";
    }

    @RequestMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
