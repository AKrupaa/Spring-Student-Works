package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.service.HistoryService;
import pl.arkadiusz.service.PdfService;
import pl.arkadiusz.service.UserAuthenticationCoreService;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class PdfController {
    private final PdfService pdfService;
    private final HistoryService historyService;
    private final UserAuthenticationCoreService coreService;
    private boolean checked = false;

    @Autowired
    public PdfController(PdfService pdfService, UserAuthenticationCoreService coreService, HistoryService historyService) {
        this.pdfService = pdfService;
        this.historyService = historyService;
        this.coreService = coreService;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @PreAuthorize("principal.getUsername() == coreService.getUserById(userCoreID)")
    @RequestMapping(value = "/generatePdf-{userCoreID}and{historyID}", method = RequestMethod.GET)
    public void generatePdf(@PathVariable Long userCoreID, @PathVariable Long historyID, HttpServletResponse response) {
//        UserAuthenticationCoreDomain userAuthenticationCoreDomain = coreService.getUserById(userCoreID);
        if (checked) {
            checked = false;
            pdfService.generatePdf(coreService.getUserById(userCoreID), historyService.getHistory(historyID), response);
        }
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(value = "/generate/pdf/{historyID}")
    public String checkPdf(@PathVariable(value = "historyID") Long historyID, Principal principal) {

        UserAuthenticationCoreDomain userCoreDomain = null;
        try {
            userCoreDomain = coreService.getUserByEmail(principal.getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            return "redirect:/home";
        }

        try {
            if (userCoreDomain.getHistoryDomains().stream().filter(historyDomain -> historyDomain.getId() == historyID).findFirst().orElse(null) == null) {
//                gosciu generuje pdfa czegos do czego nie powinien miec dostepu
                return "redirect:/accessDenied";
            }
        } catch (NullPointerException npe) {
            System.out.println("Goscia nie ma w bazie danych");
            return "redirect:/accessDenied";
        }

        String url = "redirect:/generatePdf-" + userCoreDomain.getId() + "and" + historyID;
//        return "redirect:/generatePdf-"+userCoreDomain.getId()+"and"

        checked = true;
//        pdfService.generatePdf(coreService.getUserById(userCoreDomain.getId()), historyService.getHistory(historyID), response);
        return url;

    }
}
