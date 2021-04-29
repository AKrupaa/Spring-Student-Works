package pl.arkadiusz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.arkadiusz.domain.CarTypeDomain;
import pl.arkadiusz.service.CarTypeService;

import java.util.HashSet;
import java.util.Set;

public class ModelCarTypeListConverter implements Converter<String[], Set<CarTypeDomain>> {

    private CarTypeService carTypeService;

    @Autowired
    public ModelCarTypeListConverter(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @Override
    public Set<CarTypeDomain> convert(String[] strings) {

        Set<CarTypeDomain> carTypeDomains = new HashSet<>(0);

        for (int i = 0; i < strings.length; i++) {
//            czyli ten strings zawiera (String) CarType.id - dziala tylko kiedy zaznaczysz wiecej niz jeden elemenet -
//            a nalezy go przekonwerowac z Stringa na longa,
//            a potem zgarnac caly obiekt za pomoca jego id, i przekazac do controllera (zwracajac tutaj ta liste obiektow!)
//            System.out.println("id obiektu CarTypeDomain z .jsp ($modelCarTypesList): " + strings[i]);
            carTypeDomains.add(carTypeService.getType(Long.parseLong(strings[i].trim())));
        }
//         to nalezy powotworz dla pojedynczego elementu (1 wybrany z listy)
        return carTypeDomains;
    }
}
