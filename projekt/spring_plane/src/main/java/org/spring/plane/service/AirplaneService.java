package org.spring.plane.service;

import org.spring.plane.domain.Airplane;

import java.util.List;

public interface AirplaneService {
    List<Airplane> getAirplanes();
    Airplane getAirplane(long id);
    void editAirplane(Airplane airplane);
    void deleteAirplane(long id);
    Airplane addAirplane(Airplane airplane);
}
