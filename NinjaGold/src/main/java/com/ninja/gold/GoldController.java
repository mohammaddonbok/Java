package com.axsosacademy.ninjaGold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class GoldController {
    public ArrayList<String>  activites = new ArrayList<>();

    @GetMapping("/")
    public String root (HttpSession session){
        if (session.getAttribute("gold") == null){
            session.setAttribute("gold",0);
        }

        return "/WEB-INF/ninjas.jsp";
    }

    @RequestMapping("/")
    public String process (@RequestBody() String postData, HttpSession session){
        if (session.getAttribute("gold") == null){
            session.setAttribute("gold",0);
        }

        String location = postData.substring(0,postData.indexOf("="));

        Random random = new Random();
        int gold = (int) session.getAttribute("gold");
        int n =0;
        String text = "You earned from ";
        switch (location){
            case "farm":
                n = random.nextInt(10)+10;
                break;
            case "cave":
                n= random.nextInt(5)+5;
                break;
            case "house":
                n=random.nextInt(3)+2;
                break;
            case "casino":
                n = random.nextInt(50);
                if (random.nextInt(2) == 1 )
                    n = -n;
        }
        gold +=n;
        session.setAttribute("gold",gold);
        activites.add(text+location+"this golds"+n);

        System.out.println(gold+"");

        return "redirect:/";
    }
}
