package com.eazybytes.eazyschool.controller;


import com.eazybytes.eazyschool.model.EazyClass;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.EazyClassRepository;
import com.eazybytes.eazyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    EazyClassRepository eazyClassRepository;

    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model){
        List<EazyClass> eazyClasses=eazyClassRepository.findAll();
        ModelAndView modelAndView=new ModelAndView("classes.html");
        modelAndView.addObject("eazyClasses",eazyClasses);
        modelAndView.addObject("eazyClass",new EazyClass());
        return  modelAndView;
    }


    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("eazyClass") EazyClass eazyClass){
        eazyClassRepository.save(eazyClass);
        ModelAndView modelAndView=new ModelAndView("redirect:/admin/displayClasses");
        return  modelAndView;
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<EazyClass> eazyClass = eazyClassRepository.findById(id);
        for(Person person : eazyClass.get().getPersons()){
            person.setEazyClass(null);
            personRepository.save(person);
        }
        eazyClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model,@RequestParam int classId){
        ModelAndView modelAndView=new ModelAndView("students.html");
        return  modelAndView;
    }



}
