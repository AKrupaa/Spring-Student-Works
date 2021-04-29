package org.spring.plane.dao;

import org.spring.plane.domain.Airplane;
import org.spring.plane.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

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
