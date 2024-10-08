package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Holiday;
import com.eazybytes.eazyschool.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @Autowired
    private HolidaysRepository holidaysRepository;

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
        List<Holiday> holidays=holidaysRepository.findAllHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";

    }
}
