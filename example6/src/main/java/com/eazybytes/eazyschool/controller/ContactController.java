package com.eazybytes.eazyschool.controller;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class ContactController {
    //Logger object to log the data to the console
    private static Logger log= LoggerFactory.getLogger(ContactController.class);

    private  final ContactService contactService;

    // Injecting the ContactService bean into my ContactController bean with the help of autowired
    @Autowired
    public  ContactController(ContactService contactService){
        this.contactService=contactService;
    }


    @RequestMapping("/contact")
    public  String contactController(){
        return  "contact.html";
    }


/*
    @RequestMapping(value = "/saveMsg",method=POST)
    public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum,
                                    @RequestParam String email,@RequestParam String subject,@RequestParam String message){
        log.info("Name : " + name);
        log.info("Mobile Number : " + mobileNum);
        log.info("Email Address : " + email);
        log.info("Subject : " + subject);
        log.info("Message : " + message);
        return new ModelAndView("redirect:/contact");

    }

 */

    @RequestMapping(value = "/saveMsg",method=POST)
    public ModelAndView saveMessage(Contact contact){
        ContactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }



}

