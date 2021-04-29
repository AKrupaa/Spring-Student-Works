package org.spring.plane.controller;

import org.spring.plane.domain.Airplane;
import org.spring.plane.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HelloController {

    private AirplaneService airplaneService;

    @Autowired
    public HelloController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @RequestMapping(value = "/")
    public String helloWorld(Locale locale, Model model,
                             @RequestParam(value = "booked", required = false) String booked) {

        if(booked!=null) {
            model.addAttribute("booked", "Ticket booked!");
        }

        model.addAttribute("flights", airplaneService.getAirplanes());

//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//        String formattedDate = dateFormat.format(date);
//
//        model.addAttribute("serverTime", formattedDate );



        return "homeTiles";
    }
}

