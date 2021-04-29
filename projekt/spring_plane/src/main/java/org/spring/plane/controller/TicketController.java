package org.spring.plane.controller;

import org.spring.plane.domain.Airplane;
import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.domain.Ticket;
import org.spring.plane.service.AirplaneService;
import org.spring.plane.service.CustomUserService;
import org.spring.plane.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class TicketController {

    TicketService ticketService;
    AirplaneService airplaneService;
    CustomUserService userService;

    @Autowired
    public TicketController(TicketService ticketService, AirplaneService airplaneService, CustomUserService userService) {
        this.airplaneService = airplaneService;
        this.ticketService = ticketService;
        this.userService = userService;
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/buy/ticket/on/flight/{flightID}")
    public String details(@PathVariable long flightID, Model model) {


        Airplane airplane = airplaneService.getAirplane(flightID);
//        Ticket ticket = ticketService.findFirstByAirplane_Id()

        List<Ticket> ticketsLeft = ticketService.findAllByAirplane_IdAndTakenIsFalse(flightID);

        if (ticketsLeft.size() == 0) {
            model.addAttribute("noTicketsLeft", "There is no tickets left!");
        }

        model.addAttribute("flight", airplaneService.getAirplane(flightID));
        model.addAttribute("ticket", ticketService.findFirstByAirplane_IdAndTakenIsFalse(flightID));

        return "buyOneTicketTiles";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/book/ticket/{ticketID}/on/flight/{flightID}")
    public String book(@PathVariable long flightID, @PathVariable long ticketID, Model model, Principal principal) {

        CustomUserDomain user = userService.findByLogin(principal.getName());
        Ticket ticket = ticketService.getTicket(ticketID);
//        Airplane airplane = airplaneService.getAirplane(flightID);

        ticket.setTaken(true);
        ticket = ticketService.editTicket(ticket);

        Set<Ticket> userTickets = user.getTickets();
        userTickets.add(ticket);

        user.setTickets(userTickets);
        userService.editCustomUser(user);


        return "redirect:/?booked";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/pending-tickets")
    public String pendingTickets(Model model, Principal principal) {
        CustomUserDomain user = userService.findByLogin(principal.getName());

        model.addAttribute("tickets", user.getTickets().stream().filter(ticket -> {
            return ticket.isTaken() && !ticket.isAccepted();
        }).toArray());

        return "pendingTicketsTiles";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/your-tickets")
    public String boughtTickets(Model model, Principal principal) {
        CustomUserDomain user = userService.findByLogin(principal.getName());

        model.addAttribute("tickets", user.getTickets().stream().filter(Ticket::isAccepted).toArray());

        return "yourTicketsTiles";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_WORKER')")
    @GetMapping(value = "/queue")
    public String queue(Model model,
                        Principal principal,
                        @RequestParam(value = "confirmed", required = false) String confirmed,
                        @RequestParam(value = "cancelled", required = false) String cancelled,
                        @RequestParam(value = "notFound", required = false) String notFound
    ) {

        if (confirmed != null) {
            model.addAttribute("confirmed", "Confirmed!");
        }
        if (cancelled != null) {
            model.addAttribute("cancelled", "Book cancelled!");
        }
        if (notFound != null) {
            model.addAttribute("notFound", "Book not found!");
        }

        List<Ticket> tickets = ticketService.findAllByAcceptedIsFalseAndTakenTrue();

        model.addAttribute("tickets", tickets);

        return "queueTiles";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_WORKER')")
    @GetMapping(value = "/queue/confirm/{ticketID}")
    public String queueConfirm(Model model, Principal principal, @PathVariable long ticketID) {

        Ticket ticket = ticketService.getTicket(ticketID);
        ticket.setAccepted(true);
        ticketService.editTicket(ticket);

        return "redirect:/queue?confirmed";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_WORKER')")
    @GetMapping(value = "/queue/cancel/{ticketID}")
    public String queueCancel(Model model, Principal principal, @PathVariable long ticketID) {

//        Ticket fetchedTicket = ticketService.getTicket(ticketID);
        List<CustomUserDomain> users = userService.getUsers();


        final boolean[] found = {false};

        users.forEach(customUserDomain -> {
            if (!found[0]) {

                for (Ticket ticket : customUserDomain.getTickets()) {
                    if (ticket.getId() == ticketID) {
                        ticket.setAccepted(false);
                        ticket.setTaken(false);
                        ticketService.editTicket(ticket);
                        found[0] = true;
                        return;
                    }
                }
            }
        });


        if (found[0]) {
            return "redirect:/queue?cancelled";
        } else {
            return "redirect:/queue?notFound";
        }

    }
}
