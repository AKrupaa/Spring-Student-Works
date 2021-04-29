package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.service.CarService;
import pl.arkadiusz.service.HistoryService;
import pl.arkadiusz.service.UserAuthenticationCoreService;

@RestController
@RequestMapping(value = "rest")
public class RESTController {

    private UserAuthenticationCoreService userService;
    private CarService carService;
    private HistoryService historyService;

    @Autowired
    public RESTController(UserAuthenticationCoreService userService, CarService carService, HistoryService historyService) {
        this.userService = userService;
        this.carService = carService;
        this.historyService = historyService;

    }

    @GetMapping(value = "/{email}.json", produces = "application/json")
    public UserAuthenticationCoreDomain getUserInfoInJson(@PathVariable String email) {
        return this.userService.getUserByEmail(email);
    }

    @GetMapping(value = "/{email}.xml", produces = "application/xml")
    public UserAuthenticationCoreDomain getUserInfoInXML(@PathVariable String email) {
        return this.userService.getUserByEmail(email);
    }

}
