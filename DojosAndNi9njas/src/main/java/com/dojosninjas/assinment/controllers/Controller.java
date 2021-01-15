package com.dojosninjas.assinment.controllers;


import com.dojosninjas.assinment.models.Dojo;
import com.dojosninjas.assinment.models.Ninja;
import com.dojosninjas.assinment.services.DojoNinjaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
private final DojoNinjaService serv;

    public Controller(DojoNinjaService serv) {
        this.serv = serv;
    }

    @RequestMapping("/dojo/new" )
    public String dojoForm(@ModelAttribute("addDojo")Dojo dojo){
        return "dojo.jsp";
    }
    @RequestMapping(value = "/dojo/new" ,method = RequestMethod.POST)
    public String dojoAdd(@ModelAttribute("addDojo")Dojo dojo){
Dojo d= serv.CreateDojo(dojo);
return "redirect:/dojo/new";
    }

    @RequestMapping("/ninja/new")
    public String ninjaForm(@ModelAttribute("createNinja") Ninja ninja, Model model){
        List<Dojo> dojos=serv.getDojos();
        model.addAttribute("dojos",dojos);
        return "ninja.jsp";
    }

    @RequestMapping(value = "/ninja/new" ,method = RequestMethod.POST)
    public String createNinja(@ModelAttribute("createNinja")Ninja ninja){
        serv.createNewNinja(ninja);
        return "redirect:/ninja/new";
    }
    @RequestMapping("/dojos/{id}")
    public String ShowDojoNinjas(@PathVariable("id")Long dojoId ,Model model){
        Dojo dojo=serv.getSingleDojo(dojoId);
        List<Ninja> all=dojo.getNinjas();
        model.addAttribute("dojo",dojo);
        model.addAttribute("allNinja",all);

        return "showDojo.jsp";
    }
}
