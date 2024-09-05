package com.eazybytes.eazyschool.controller;
import com.eazybytes.eazyschool.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
public class ProfileController {

    @RequestMapping("/displayProfile")
    public ModelAndView displayMessages(Model model){
        Profile profile=new Profile();
        ModelAndView modelAndView=new ModelAndView("profile.html");
        modelAndView.addObject("profile",profile);
        return  modelAndView;
    }

}
