package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.arkadiusz.domain.HistoryDomain;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.service.CarService;
import pl.arkadiusz.service.HistoryService;
import pl.arkadiusz.service.UserAuthenticationCoreService;
import pl.arkadiusz.utils.ParsingDateAndTime;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class HistoryController {

    private final UserAuthenticationCoreService coreService;
    private final HistoryService historyService;
    private final CarService carService;
    private final ParsingDateAndTime parsingDateAndTime;

    @Autowired
    public HistoryController(UserAuthenticationCoreService coreService,
                                   HistoryService historyService,
                                   CarService carService) {
        this.coreService = coreService;
        this.historyService = historyService;
        this.carService = carService;
        this.parsingDateAndTime = new ParsingDateAndTime();
    }

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping(value = "/info/history")
    public String activeBooking(Model model, Principal principal) {

        UserAuthenticationCoreDomain userCoreDomain = null;
        try {
            userCoreDomain = coreService.getUserByEmail(principal.getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            return "redirect:/home";
        }

        Set<HistoryDomain> historyDomains = userCoreDomain.getHistoryDomains();
        if (historyDomains == null || historyDomains.isEmpty()) {
            System.out.println("brak historii");
            model.addAttribute("modelHistoryList", new ArrayList<>(0));
            return "historyTiles";
        }

        List<HistoryDomain> historyDomainList = new ArrayList<>(historyDomains);

        List<HistoryDomain> actuallyHistory = new ArrayList<>(0);

        for (int index = 0; index < historyDomains.size(); index++) {
            HistoryDomain obj = historyDomainList.get(index);
            if (obj.isCompleted())
                actuallyHistory.add(obj);
        }

        model.addAttribute("modelHistoryList", actuallyHistory);

        return "historyTiles";
    }
}
