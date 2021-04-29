package org.spring.plane.service;

import org.spring.plane.dao.AirplaneRepository;
import org.spring.plane.domain.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AirplaneServiceImp implements AirplaneService {

    AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneServiceImp(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public List<Airplane> getAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane getAirplane(long id) {
        return airplaneRepository.getOne(id);
    }

    @Override
    public void editAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public void deleteAirplane(long id) {
        airplaneRepository.delete(id);
    }

    @Override
    public Airplane addAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }
}
