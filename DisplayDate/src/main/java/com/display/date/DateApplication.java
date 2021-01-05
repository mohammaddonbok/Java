package com.display.date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Controller
public class DateApplication {

    public static void main(String[] args) {

        SpringApplication.run(DateApplication.class, args);
    }
    @RequestMapping("/")
public String show(Model model){
        Date date = new Date();
        model.addAttribute("rightNow", date);
        return "index.jsp";
}
@RequestMapping("/{dt}")
public String DateTime(@PathVariable("dt") String dt, Model model) {
    if(!dt.equals("date") && !dt.equals("time"))
        return "redirect:/";
    SimpleDateFormat dm = (dt.equals("date"))
            ? new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY")
            : new SimpleDateFormat("h:mm a");
    model.addAttribute("dtFormat", dm.format(new java.util.Date()));
    model.addAttribute("dt", dt);
    return "datetime.jsp";
}
}
