package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arkadiusz.domain.CarDomain;
import pl.arkadiusz.domain.HistoryDomain;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.service.CarService;
import pl.arkadiusz.service.HistoryService;
import pl.arkadiusz.service.UserAuthenticationCoreService;
import pl.arkadiusz.utils.ParsingDateAndTime;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class PurchaseController {

    private final HistoryService historyService;
    private final UserAuthenticationCoreService coreService;
    private final CarService carService;
    private final ParsingDateAndTime parsingDateAndTime;

    @Autowired
    public PurchaseController(HistoryService historyService,
                              UserAuthenticationCoreService coreService,
                              CarService carService) {
        this.historyService = historyService;
        this.coreService = coreService;
        this.carService = carService;
        this.parsingDateAndTime = new ParsingDateAndTime();
    }


    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(value = "/info/purchase/{carID}")
    public String purchaseView(@PathVariable(value = "carID") long carID,
                               Principal principal,
                               Model model) {

//        UserAuthenticationCoreDomain userCoreDomain = coreService.getUserByEmail(principal.getName());

        CarDomain car = carService.getCarById(carID);
        model.addAttribute("modelCar", car);

//        HistoryDomain historyDomain = new HistoryDomain();
//        model.addAttribute("modelHistory", historyDomain);


        return "purchaseCarTiles";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping(value = "/purchase/{carID}")
    public String purchase(@PathVariable(value = "carID") long carID,
//                           @ModelAttribute("modelHistory") HistoryDomain historyDomain,
                           Principal principal,
                           HttpServletRequest request) {

        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/home";
        }

//        String name = principal.getName();
//        if (name == "admin@admin.admin")
//            return "redirect:/home";
//        if (principal.getName())
//            return "redurect:/home";

        CarDomain carDomain = carService.getCarById(carID);
        if (carDomain.isRented())
            return "redirect:/home";


        UserAuthenticationCoreDomain userCoreDomain = null;
        try {
            userCoreDomain = coreService.getUserByEmail(principal.getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            System.out.println("PurchaseController @PostMapping /purchase/" + carID);
            System.out.println("W skrocie: zaloguj sie przed zakupem samochodu.");
            return "redirect:/home";
        }

        HistoryDomain historyDomain = new HistoryDomain();

//        car rented - > true, save in database
        carDomain.setRented(true);
//        save changes in database
        carService.editCar(carDomain);

//        history -> set rental time, start renting, associate with car {carID}
        Date actualDate = parsingDateAndTime.getActualDate();
        historyDomain.setRentalStartDateAndTime(actualDate.getTime());
        historyDomain.setRentalStartDateAndTimeString(parsingDateAndTime.parseDate(actualDate));
        historyDomain.setRentalEndDateAndTime(null);
        historyDomain.setRentalEndDateAndTimeString(null);
        historyDomain.setCostsOfRental(null);
        historyDomain.setCompleted(false);
        historyDomain.setCarDomain(carDomain);

//        add to database
        historyService.addHistory(historyDomain);

//        USER CORE
        try {
            userCoreDomain.getHistoryDomains().add(historyDomain);
//            fetchedHistory.add(historyDomain);
            coreService.editUserCore(userCoreDomain);
        } catch (NullPointerException e) {
            System.out.println();
            System.out.println("Uzytkownik: " + userCoreDomain.getEmail());
            System.out.println("nie ma jeszcze wypozyczen!");
            System.out.println();

//            utworzneie setu, dodanie historii, przypisanie obiektu, wrzucenie do bazy danych
            Set<HistoryDomain> historyDomainSet = new HashSet<>();
            historyDomainSet.add(historyDomain);
            userCoreDomain.setHistoryDomains(historyDomainSet);
            coreService.editUserCore(userCoreDomain);

        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace().toString());
//            return "redirect:/info/purchase/"+carID;
        }

        return "redirect:/info/purchase/" + carID;
    }
}
