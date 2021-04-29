package pl.arkadiusz.service;

import pl.arkadiusz.domain.CarDomain;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public interface CarService {
//    public boolean isRented(Long id);
    public CarDomain getCarById(long id);
    public List<CarDomain> getCars();
    public void removeCarById(long id);
    public void editCar(CarDomain car);
    public void addCar(CarDomain car);
    public List<Long> findAllIdsWhereCarIsNotRented();
    public List<CarDomain> findAllCarDomainsWhereCarIsNotRented();
}
