package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// Controller annotation indicates that a particular class serves the role of a controller

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String displayHomePage(){
        return "Home.html";
    }
}
