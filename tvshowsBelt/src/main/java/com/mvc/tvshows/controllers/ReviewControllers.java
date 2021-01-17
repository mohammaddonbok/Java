package com.mvc.tvshows.controllers;

import com.mvc.tvshows.models.Rate;
import com.mvc.tvshows.models.Show;
import com.mvc.tvshows.models.User;
import com.mvc.tvshows.services.Services;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ReviewControllers {
    private final Services service;

    public ReviewControllers(Services service) {
        this.service = service;
    }


    @PostMapping("/shows/{id}/review")
    public String review(@Valid @ModelAttribute("review") Rate rate, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You must be logged in to view that page!");
            return String.format("redirect:/shows/%d", id);
        }
        if(result.hasErrors()) {
            model.addAttribute("show", service.findOneById(id));
            model.addAttribute("user", service.findUserById(userId));
            return "displayShow.jsp";
        } else {
            User u = service.findUserById(userId);
            Show s = service.findOneById(id);
            List<Rate> rates = s.getReviews();
            for(Rate r: rates) {
                if(r.getUser().getId() == u.getId()) {
                    flash.addFlashAttribute("error", "You already Rate this show!");
                    return String.format("redirect:/shows/%d", id);
                }
            }

            rate.setId(null);
            Rate newR = service.create(rate);
            if(s.getAvgRating() == null) {
                s.setAvgRating(newR.getRating()/1.0);
                service.update(s);
            } else {
                Double sum = 0.0;
                for(Rate r: rates) {
                    sum += r.getRating();
                }
                sum += newR.getRating();
                s.setAvgRating(sum/(rates.size()+1));
                service.update(s);
            }
            return String.format("redirect:/shows/%d", id);
        }
    }
}
