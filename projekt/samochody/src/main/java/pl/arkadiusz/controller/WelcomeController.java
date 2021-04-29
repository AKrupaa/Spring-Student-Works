package pl.arkadiusz.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class WelcomeController {

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping(value = "/welcome/user")
    public String welcomeUser(Model model, Principal principal) {

        model.addAttribute("Information", "You have been logged successfully!");

        return "welcomePage";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(value = "/welcome/register")
    public String welcomeRegister(Model model, Principal principal) {
        model.addAttribute("Information", "You have benn registered successfully!<br>You can log in :-)");
        return "welcomePage";
    }

    @RequestMapping(value = "/")
    public String welcome(Locale locale, Model model, Principal principal) {

//        try {
//            String name = principal.getName();
//            return "redirect:/home";
//        } catch(Exception exception){
//            model.addAttribute()
//        }

//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//        String formattedDate = dateFormat.format(date);
//
//        model.addAttribute("serverTime", formattedDate );

        return "welcomePage";
    }

    @RequestMapping(value = "/RegisterOrLoginPage")
    public String registerOrLogin() {
        return "RegisterOrLoginTiles";
    }
}

