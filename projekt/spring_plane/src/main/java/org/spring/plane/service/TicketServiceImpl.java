package org.spring.plane.service;

import org.spring.plane.dao.TicketRepository;
import org.spring.plane.domain.Airplane;
import org.spring.plane.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TicketServiceImpl implements TicketService{

    TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getTickets() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Ticket getTicket(long id) {
        return this.ticketRepository.findOne(id);
    }

    @Override
    public Ticket editTicket(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(long id) {
    this.ticketRepository.delete(id);
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void addTickets(List<Ticket> tickets) {
        this.ticketRepository.save(tickets);
    }

    @Override
    public Ticket findFirstByAirplane_Id(Long airplaneID) {
        return this.ticketRepository.findFirstByAirplane_Id(airplaneID);
    }

    @Override
    public Ticket findFirstByAirplane(Airplane airplane) {
        return this.ticketRepository.findFirstByAirplane(airplane);
    }

    @Override
    public List<Ticket> findAllByAirplane_Id(Long airplaneID) {
        return this.ticketRepository.findAllByAirplane_Id(airplaneID);
    }

    @Override
    public List<Ticket> findAllByAirplane(Airplane airplane) {
        return this.ticketRepository.findAllByAirplane(airplane);
    }

    @Override
    public Ticket findFirstByAirplane_IdAndTakenIsFalse(Long airplaneID) {
        return this.ticketRepository.findFirstByAirplane_IdAndTakenIsFalse(airplaneID);
    }

    @Override
    public Ticket findFirstByAirplaneAndTakenIsFalse(Airplane airplane) {
        return this.ticketRepository.findFirstByAirplaneAndTakenIsFalse(airplane);
    }

    @Override
    public List<Ticket> findAllByAirplane_IdAndTakenIsFalse(Long airplaneID) {
        return this.ticketRepository.findAllByAirplane_IdAndTakenIsFalse(airplaneID);
    }

    @Override
    public List<Ticket> findAllByAirplaneAndTakenIsFalse(Airplane airplane) {
        return this.ticketRepository.findAllByAirplaneAndTakenIsFalse(airplane);
    }

    @Override
    public List<Ticket> findAllByAcceptedIsFalseAndTakenTrue() {
        return this.ticketRepository.findAllByAcceptedIsFalseAndTakenTrue();
    }
}
