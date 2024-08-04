package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {
    @GetMapping("/holidays/{display}")
    public  String display_holidays(@PathVariable String display, Model model){

        if(display!=null&&display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(display!=null&&display.equals("federal")) {
            model.addAttribute("federal", true);
        }else if(display!=null && display.equals("festival")){
            model.addAttribute("festival",true);
        }
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 29 ","Raksha Bandhan", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 2 ","Mahatma Gandhi Day", Holiday.Type.FEDERAL),
                new Holiday(" Aug 15 ","Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Jan 26 ","Republic Day", Holiday.Type.FEDERAL),
                new Holiday(" May 8 ","Guru Rabindranath's Birthday", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";

    }
}
