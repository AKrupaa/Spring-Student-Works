package pl.arkadiusz.service;

import pl.arkadiusz.domain.CarDomain;
import pl.arkadiusz.domain.CarTypeDomain;

import java.util.List;

public interface CarTypeService {

    List<CarTypeDomain> getTypes();

    CarTypeDomain getType(long id);

    void removeType(String description);

    void removeType(long id);

    void editType(CarTypeDomain carTypeDomain);

    void addType(CarTypeDomain carTypeDomain);

    CarTypeDomain getCarTypeByDescription(String description);

}
