package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.dao.CarRepository;
import pl.arkadiusz.domain.CarDomain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
//    @Override
//    public boolean isRented(Long id) {
//        return false;
//    }

    CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDomain getCarById(long id) {
        return carRepository.findCarDomainById(id);
    }

    @Override
    public List<CarDomain> getCars() {
        return carRepository.findAll();
    }

    @Override
    public void removeCarById(long id) {
        carRepository.delete(id);
    }

    @Override
    public void editCar(CarDomain car) {
        if (car.getCarTypes().isEmpty()) {
            CarDomain carDomain = getCarById(car.getId());
            if(carDomain.getCarTypes() != null)
                car.setCarTypes(carDomain.getCarTypes());
        }
        carRepository.save(car);
    }

    @Override
    public void addCar(CarDomain car) {
        carRepository.save(car);
    }

    @Override
    public List<Long> findAllIdsWhereCarIsNotRented() {
        List<BigInteger> bigIntegers = carRepository.findAllIdsWhereCarIsNotRented();
        List<Long> longList = new ArrayList<>();
//      TODO: JAK OBEJSC * BIG INTEGER ...
        for (int i = 0; i < bigIntegers.size(); i++) {
            longList.add(bigIntegers.get(i).longValue());
        }
        return longList;
    }

    @Override
    public List<CarDomain> findAllCarDomainsWhereCarIsNotRented() {
        return carRepository.findAllCarDomainsWhereCarIsNotRented();
    }
}
