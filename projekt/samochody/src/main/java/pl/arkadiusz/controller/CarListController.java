package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.arkadiusz.service.CarService;

@Controller
public class CarListController {

    private CarService carService;

    @Autowired
    public CarListController(CarService carService) {
        this.carService= carService;
    }

    @GetMapping(value = "/availableCars")
    public String getAvailableCars(Model model) {

        model.addAttribute("modelCarList", carService.getCars());
        
        return "carsListTiles";
    }

}
