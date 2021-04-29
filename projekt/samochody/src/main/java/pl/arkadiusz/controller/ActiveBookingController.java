package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.arkadiusz.domain.CarDomain;
import pl.arkadiusz.domain.HistoryDomain;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.service.CarService;
import pl.arkadiusz.service.HistoryService;
import pl.arkadiusz.service.UserAuthenticationCoreService;
import pl.arkadiusz.utils.ParsingDateAndTime;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class ActiveBookingController {

    private final UserAuthenticationCoreService coreService;
    private final HistoryService historyService;
    private final CarService carService;
    private final ParsingDateAndTime parsingDateAndTime;
    private String nameOfACar = null;

    @Autowired
    public ActiveBookingController(UserAuthenticationCoreService coreService,
                                   HistoryService historyService,
                                   CarService carService) {
        this.coreService = coreService;
        this.historyService = historyService;
        this.carService = carService;
        this.parsingDateAndTime = new ParsingDateAndTime();
    }

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping(value = "/info/active")
    public String activeBooking(Model model, Principal principal) {

//        try{
//            principal.getName();
//        } catch (NullPointerException npe) {
//            System.out.println(npe.fillInStackTrace().toString());
//            return "redirect:/home";
//        }

        UserAuthenticationCoreDomain userCoreDomain = null;
        try {
            userCoreDomain = coreService.getUserByEmail(principal.getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            return "redirect:/home";
        }

//        if (userCoreDomain == null)
//            return "redirect:/home";

        Set<HistoryDomain> historyDomains = userCoreDomain.getHistoryDomains();
        if (historyDomains == null || historyDomains.isEmpty()) {
            System.out.println("brak historii");
            return "redirect:/home";
        }

        List<HistoryDomain> historyDomainList = new ArrayList<>(historyDomains);

        List<HistoryDomain> actuallyBooking = new ArrayList<>(0);

        for (int index = 0; index < historyDomains.size(); index++) {
            HistoryDomain obj = historyDomainList.get(index);
            if (!obj.isCompleted())
                actuallyBooking.add(obj);
        }

        model.addAttribute("modelBooking", actuallyBooking);
//        if(nameOfACar != null)

//        nameOfACar = null;
        model.addAttribute("LastRentalModel", nameOfACar);
        return "activeBookingTiles";
    }

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping(value = "/rental/end/{historyID}")
    public String finishCarRental(@PathVariable(value = "historyID") long historyID,
                                  Principal principal) {

//        UserAuthenticationCoreDomain userCoreDomain = null;
//        try {
//            userCoreDomain = coreService.getUserByEmail(principal.getName());
//        } catch (NullPointerException npe) {
//            System.out.println(npe.fillInStackTrace().toString());
//            return "redirect:/home";
//        }

        HistoryDomain historyDomain = null;
        try {
            historyDomain = historyService.getHistory(historyID);
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            return "redirect:/home";
        }

        if (historyDomain.isCompleted())
            return "redirect:/home";


        CarDomain carDomain = historyDomain.getCarDomain();
        carDomain.setRented(false);

        java.util.Date old = parsingDateAndTime.parseTimestamp(historyDomain.getRentalStartDateAndTimeString());
        Date current = parsingDateAndTime.getActualDate();
        Long diff = parsingDateAndTime.calculateDifferenceBetweenDateInstances(old, current);

        historyDomain.setRentalEndDateAndTime(current.getTime());
        historyDomain.setRentalEndDateAndTimeString(parsingDateAndTime.parseDate(current));
        historyDomain.setCostsOfRental(diff / 1000L / 60L * carDomain.getPrice());
        historyDomain.setCompleted(true);

        carService.editCar(carDomain);
        historyService.editHistory(historyDomain);

//        List<HistoryDomain> historyDomainList = new ArrayList<>(userCoreDomain.getHistoryDomains());
//        HistoryDomain historyDomain = historyDomainList.stream()
//                .filter(history -> history.getId() == historyID)
//                .findFirst()
//                .orElse(null);
//
//        if (historyDomain == null)
//            return "/home";
        nameOfACar = carDomain.getName();
        return "redirect:/info/active";
    }
}
