package com.surveydojo.dojo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class main {
    @RequestMapping("/")
    public String main(){

        return "main.jsp";
    }
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public String info(@RequestParam(value = "name")String name, @RequestParam(value = "location")String location, @RequestParam(value = "language")String language, @RequestParam(value = "comment")String comment, HttpSession session){
    session.setAttribute("name",name);
    session.setAttribute("location",location);
    session.setAttribute("language",language);
    session.setAttribute("comment",comment);
    return "result.jsp";

    }
}
