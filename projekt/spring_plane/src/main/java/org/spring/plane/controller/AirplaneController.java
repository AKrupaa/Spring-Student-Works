package org.spring.plane.controller;

import org.spring.plane.domain.Airplane;
import org.spring.plane.domain.Ticket;
import org.spring.plane.service.AirplaneService;
import org.spring.plane.service.TicketService;
import org.spring.plane.validator.AirplaneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class AirplaneController {

    AirplaneService airplaneService;
    AirplaneValidator airplaneValidator = new AirplaneValidator();
    TicketService ticketService;


    @Autowired
    public AirplaneController(AirplaneService airplaneService, TicketService ticketService) {
        this.airplaneService = airplaneService;
        this.ticketService = ticketService;
    }


    @GetMapping(value = "/airplane")
    public String show(Model model, @RequestParam(value = "warning", required = false) String warning,
                       @RequestParam(value = "flight", required = false) String flight) {


        if (warning != null) {
            model.addAttribute("warning", "Data format: MM-dd-yyyy HH:mm");
        }

        if (flight != null) {
            model.addAttribute("flight", "Flight added!");
        }

        model.addAttribute("airplane", new Airplane());
        model.addAttribute("airplanes", airplaneService.getAirplanes());

        return "airplaneTiles";
    }

    @GetMapping(value = "/edit/airplane/{airplaneID}")
    public String editOne(
            @PathVariable long airplaneID,
            Model model) {

        model.addAttribute("airplane", airplaneService.getAirplane(airplaneID));

        return "editOneAirplaneTiles";
    }


    @PostMapping(value = "/airplane")
    public String add(@Valid Model model, @ModelAttribute("airplane") Airplane airplane, BindingResult result) {

        airplaneValidator.validate(airplane, result);

        if (result.getErrorCount() > 0) {
            return "redirect:/airplane?warning";
        }


        Airplane air = airplaneService.addAirplane(airplane);

        List<Ticket> ticketList = new ArrayList<>(0);
        for (int i = 0; i < 10; i++) {
            Ticket ticket = new Ticket();
            ticket.setAirplane(air);
            ticket.setPrice(200);
            ticket.setAccepted(false);
            ticketList.add(ticket);
        }

        this.ticketService.addTickets(ticketList);

        return "redirect:/airplane?flight";
    }

    @PostMapping(value = "/update/airplane")
    public String upload(Model model, @ModelAttribute("airplane") Airplane airplane) {

        Airplane fetched = this.airplaneService.getAirplane(airplane.getId());
        airplane.setDeparture(fetched.getDeparture());
        airplane.setArrival(fetched.getArrival());

        airplaneService.editAirplane(airplane);
        return "redirect:/airplane";
    }

    @GetMapping(value = "/delete/airplane/{airplaneID}")
    public String delete(Model model, @PathVariable long airplaneID) {

        List<Ticket> ticketsOfAirplane = ticketService.findAllByAirplane_Id(airplaneID);
        ticketsOfAirplane.forEach(ticket -> {
            this.ticketService.deleteTicket(ticket.getId());
        });

        airplaneService.deleteAirplane(airplaneID);
        return "redirect:/airplane";
    }
}
