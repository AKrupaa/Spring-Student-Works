package pl.arkadiusz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.arkadiusz.domain.CarTypeDomain;
import pl.arkadiusz.service.CarTypeService;

import java.util.HashSet;
import java.util.Set;

/*
    Sprawdz pierw ModelCarTypeListConverter - aby zrozumiec sens tych konwerterow...
 */

public class ModelCarTypeConverter implements Converter<String, Set<CarTypeDomain>> {

    private CarTypeService carTypeService;

    @Autowired
    public ModelCarTypeConverter(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }


    @Override
    public Set<CarTypeDomain> convert(String s) {

        //        tak jak nizej nie moze byc, bo w @Entity masz Set<> ... :)
//        CarTypeDomain carTypeDomain = carTypeService.getType(Long.getLong(s));

        Set<CarTypeDomain> carTypeDomains = new HashSet<>(0);
//        Long.getLong(string) -> EXCEPTION, ktory oczywiscie sie nie printuje, Boze, dzieki za debuggowanie
//        trimuj........
//        carTypeDomains.add(carTypeService.getType(Long.parseLong(s.trim())));
        carTypeDomains.add(carTypeService.getType(Long.parseLong(s.trim())));
//        System.out.println(carTypeDomains);
        return carTypeDomains;
    }
}
