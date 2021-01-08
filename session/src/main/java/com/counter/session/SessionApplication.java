package com.counter.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class SessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionApplication.class, args);
    }

    @RequestMapping("/")
    public String welcome(HttpSession session){
     if(session.isNew()){
         session.setAttribute("count",0);
     }
     else{
         Integer count =(Integer) session.getAttribute("count");
         count+=1;
         session.setAttribute("count",count);

     }
        return "counter.jsp";
    }
    @RequestMapping("/counter")
    public String counter(HttpSession session){

return "countResult.jsp";

    }
}
