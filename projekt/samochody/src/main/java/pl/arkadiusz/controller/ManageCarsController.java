package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arkadiusz.domain.CarDomain;
import pl.arkadiusz.domain.CarTypeDomain;
import pl.arkadiusz.service.CarService;
import pl.arkadiusz.service.CarTypeService;
import pl.arkadiusz.validator.ManageCarsValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class ManageCarsController {

    CarService carService;
    CarTypeService carTypeService;
    ManageCarsValidator manageCarsValidator = new ManageCarsValidator();
    private long editCarId = -1;

    @Autowired
    public ManageCarsController(CarService carService, CarTypeService carTypeService) {

        this.carService = carService;
        this.carTypeService = carTypeService;
    }


    // show car/cars
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/manageCars")
    public String showAddNewCarPage(Model model) {

//        model.addAttribute("modelCar");

        if (editCarId > 0) {
            CarDomain carDomain = carService.getCarById(editCarId);
            Set<CarTypeDomain> carTypeDomains = carDomain.getCarTypes();

            List<CarTypeDomain> carTypeDomainList = new ArrayList<>(carTypeDomains);
            model.addAttribute("selectedCarTypeList", carTypeDomainList);
            model.addAttribute("modelCar", carService.getCarById(editCarId));
        } else {
            model.addAttribute("modelCar", new CarDomain());
//            model.addAttribute("modelCarType", new CarTypeDomain());
        }


        model.addAttribute("modelCarList", carService.getCars());
        model.addAttribute("modelCarTypesList", carTypeService.getTypes());
//        model.addAttribute("")
        this.editCarId = -1;

        return "manageCarsTiles";
    }

    // add car
    @Secured("ROLE_ADMIN" )
    @PostMapping(value = "/add/car")
    public String addNewCar(@Valid @ModelAttribute("modelCar") CarDomain car, Model model, BindingResult result) {

        // print what you got
        System.out.println();
        System.out.println(car.getId());
        System.out.println(car.getName());
        System.out.println(car.getTitle());
        System.out.println(car.getDescription());
        System.out.println(car.getPrice());
        System.out.println(car.getSourceImage());
        System.out.println(car.isRented());
//        System.out.println(car.getCarTypes());
        System.out.println();

        manageCarsValidator.validate(car, result);

        if (result.getErrorCount() == 0) {
//        add new car
            if (car.getId() == 0) {
                carService.addCar(car);
//            return "redirect:carsPage";
//            modify existing car
            } else if (car.getId() > 0) {
//                if (car.getCarTypes().isEmpty())
//                    car.setCarTypes(carService.getCarById(editCarId).getCarTypes());
                carService.editCar(car);
//            return "redirect:carsPage";
            }
            return "redirect:/manageCars";
        }

        model.addAttribute("modelCarList", carService.getCars());
        model.addAttribute("modelCarTypesList", carTypeService.getTypes());
        return "manageCarsTiles";
//        return "redirect:/manageCars";
    }

    // delete car
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/delete/car/{carID}")
    public String deleteCar(@PathVariable(value = "carID") long carID, Model model) {
        try {
            carService.removeCarById(carID);
        } catch (Exception exception) {
            model.addAttribute("modelDelete", "ERROR");
            model.addAttribute("modelCar", new CarDomain());
            model.addAttribute("modelCarList", carService.getCars());
            model.addAttribute("modelCarTypesList", carTypeService.getTypes());
            return "manageCarsTiles";
        }

        return "redirect:/manageCars";
    }

    // edit car
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/edit/car/{carID}")
    public String editCar(@PathVariable(value = "carID") long carID) {
        editCarId = carID;
        return "redirect:/manageCars";
    }
}
