package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arkadiusz.domain.CarTypeDomain;
import pl.arkadiusz.service.CarTypeService;
import pl.arkadiusz.validator.ManageCarTypeValidator;

@Controller
public class ManageCarTypeController {

    ManageCarTypeValidator manageCarsValidator = new ManageCarTypeValidator();
    private final CarTypeService carTypeService;
    private long editedCarTypeId = -1;

    @Autowired
    public ManageCarTypeController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }


    // show car/cars
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/manageCarType")
    public String showCarTypePage(Model model) {

        if (editedCarTypeId > 0) {
            model.addAttribute("modelCarType", carTypeService.getType(editedCarTypeId));
        } else {
            model.addAttribute("modelCarType", new CarTypeDomain());
        }

        model.addAttribute("modelCarTypeList", carTypeService.getTypes());
        editedCarTypeId = -1;

        return "manageCarTypeTiles";
    }

    // add car type
    @Secured("ROLE_ADMIN" )
    @PostMapping(value = "/add/carType")
    public String addNewCarType(@ModelAttribute("modelCarType") CarTypeDomain car, Model model, BindingResult result) {

        // print what you got
        System.out.println();
        System.out.println("ManageCarTypeController -> @POST");
        System.out.println(car.getId());
        System.out.println(car.getDescription());
        System.out.println();

        manageCarsValidator.validate(car, result);

        if (result.getErrorCount() == 0) {
//        add new car type
            if (car.getId() == 0) {
                carTypeService.addType(car);
//            return "redirect:carsPage";
//            modify existing car type
            } else if (car.getId() > 0) {
                carTypeService.editType(car);
//            return "redirect:carsPage";
            }
            return "redirect:/manageCarType";
        }

        model.addAttribute("modelCarTypeList", carTypeService.getTypes());
        return "manageCarTypeTiles";
//        return "redirect:/manageCars";
    }

    // delete car type
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/delete/carType/{carID}")
    public String deleteCar(@PathVariable(value = "carID") long carID) {
        carTypeService.removeType(carID);
        return "redirect:/manageCarType";
    }

    // edit car type
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/edit/carType/{carID}")
    public String editCar(@PathVariable(value = "carID") long carID) {
        editedCarTypeId = carID;
        return "redirect:/manageCarType";
    }

}
