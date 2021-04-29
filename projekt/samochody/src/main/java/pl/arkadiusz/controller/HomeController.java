package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arkadiusz.domain.CarDomain;
import pl.arkadiusz.service.CarService;

import java.math.BigInteger;
import java.util.*;

@Controller
public class HomeController {

    CarService carService;

    @Autowired
    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/home")
    public String home(Model model) {

//        jezeli tylko 5 mamy samochod - wypisz 5, inaczej zrob randoma z 5.

        List<Long> carIdsNotRented = carService.findAllIdsWhereCarIsNotRented();
        int max = carIdsNotRented.size();
        List<CarDomain> carDomainList;

        if (max > 6) {
            carDomainList = new ArrayList<CarDomain>(0);
            Random random = new Random();
            Set<Integer> generated = new LinkedHashSet<Integer>();
//            how many cars to display on page
            short numbersNeeded = 3;
            while (generated.size() < numbersNeeded) {
                Integer next = random.nextInt(max);
                // As we're adding to a set, this will automatically do a containment check
                generated.add(next);
            }

            List<Integer> generatedList = new ArrayList<>(generated);
//            for (int i = 0; i < carIdsNotRented.size(); i++) {
//                String value = carIdsNotRented.get(i).toString();
////                carIdsNotRented.set(i, value.trim());
//            }

            for (int index = 0; index < generatedList.size(); index++) {
                int id = generatedList.get(index);
                long carIdToFetch;

                carIdToFetch = carIdsNotRented.get(id);

//                ((BigInteger) yourBigIntegerValue).intValue();
                carDomainList.add(carService.getCarById(carIdToFetch));
            }
        } else {
            carDomainList = carService.findAllCarDomainsWhereCarIsNotRented();
            if(carDomainList.size() > 3)
                carDomainList = carDomainList.subList(0,3);
        }

        model.addAttribute("modelRandomCarList", carDomainList);
        return "homeTiles";
    }
}
