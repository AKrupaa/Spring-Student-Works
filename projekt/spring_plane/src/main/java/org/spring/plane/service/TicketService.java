package org.spring.plane.service;

import org.spring.plane.domain.Airplane;
import org.spring.plane.domain.Ticket;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface TicketService {

    List<Ticket> getTickets();

    Ticket getTicket(long id);

    Ticket editTicket(Ticket ticket);

    void deleteTicket(long id);

    Ticket addTicket(Ticket ticket);

    void addTickets(List<Ticket> tickets);

    Ticket findFirstByAirplane_Id(Long airplaneID);

    Ticket findFirstByAirplane(Airplane airplane);

    List<Ticket> findAllByAirplane_Id(Long airplaneID);

    List<Ticket> findAllByAirplane(Airplane airplane);

    Ticket findFirstByAirplane_IdAndTakenIsFalse(Long airplaneID);

    Ticket findFirstByAirplaneAndTakenIsFalse(Airplane airplane);

    List<Ticket> findAllByAirplane_IdAndTakenIsFalse(Long airplaneID);

    List<Ticket> findAllByAirplaneAndTakenIsFalse(Airplane airplane);

    List<Ticket> findAllByAcceptedIsFalseAndTakenTrue();
}
