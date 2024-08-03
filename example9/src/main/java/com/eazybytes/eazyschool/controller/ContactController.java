package com.eazybytes.eazyschool.controller;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {
  private  final ContactService contactService;

  @Autowired
    public  ContactController(ContactService contactService)
  {
        this.contactService=contactService;
  }



    @RequestMapping("/contact")
    public  String contactController(Model model){
     /*
     This line adds an attribute to the Model object.
     The attribute's name is "contact", and its value is a new instance of the Contact class.
     This allows the view (in this case, "contact.html") to access the "contact" object.
      */

      model.addAttribute("contact",new Contact());
      return  "contact.html";
    }




/*
        @Valid se pta chalta hai spring MVC ko kii validation karna hai

        When you see @ModelAttribute("contact"),
        it typically means that the "contact" object is being added to the model,
        making it available in the view (e.g., a Thymeleaf template, JSP, etc.).

        Model Attribute: The @ModelAttribute("contact") annotation binds the form data
        to the contact object, making it available for validation and further processing.

        The Errors errors object captures any validation errors.If there are validation errors,
        the method logs the errors and returns the contact.html view to the user.

 */
    @RequestMapping(value = "/saveMsg",method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

}

