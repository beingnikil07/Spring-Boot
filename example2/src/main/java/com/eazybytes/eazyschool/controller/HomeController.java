package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller annotation indicates that a particular class serves the role of a controller

@Controller
public class HomeController {

    @RequestMapping(value = {"","/","Home"})
    //Model is an interface present in spring mvc framework which act as a container between your UI and backend code
    public String displayHomePage(Model model){
        model.addAttribute("username","Nikhil");
        return "Home.html";
    }

}
