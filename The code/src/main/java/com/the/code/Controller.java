package com.the.code;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String main(){

        return "main.jsp";

    }
    @RequestMapping(value="/check",method = RequestMethod.POST )
    public String check(@RequestParam(value = "code")String code, RedirectAttributes redirectAttributes){
        if(code.equals("bushido")){
            return "theCode.jsp";

        }
        else{
            redirectAttributes.addFlashAttribute("error","You must train harder");
             return "redirect:/";
        }

    }

}
