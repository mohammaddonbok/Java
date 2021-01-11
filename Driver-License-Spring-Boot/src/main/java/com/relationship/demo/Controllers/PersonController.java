package com.relationship.demo.Controllers;

import com.relationship.demo.Services.PersonService;
import com.relationship.demo.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PersonController {
    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("person/new")
    public String showAddPersonForm(@ModelAttribute("person")Person person){
        return "person/new.jsp";
    }

    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model){
        if (result.hasErrors()){
            return "person/new.jsp";
        }else {
           Person p = personService.addPerson(person);
            model.addAttribute("person",p);
            return "redirect:/person/"+p.getId();
        }
    }



        @RequestMapping("person/{id}")
        public String show(@PathVariable("id") Long id ,Model model ) {
            Person p=personService.findPersonById(id);
            model.addAttribute("person",p);

             return "person/showInfo.jsp";
        }


}








