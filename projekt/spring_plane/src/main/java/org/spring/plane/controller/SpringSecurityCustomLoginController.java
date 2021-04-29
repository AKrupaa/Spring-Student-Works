package org.spring.plane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpringSecurityCustomLoginController {

    @RequestMapping(value = "/login")
    public String customLogin(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              @RequestParam(value = "registered", required = false) String registered,
                              @RequestParam(value = "alreadyExist", required = false) String alreadyExist,
                              Model model,
                              HttpServletRequest request) {

        if(alreadyExist!= null) {
            model.addAttribute("alreadyExist", "User exists");
        }

        if (error != null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully");
        }

        if (registered != null) {
            model.addAttribute("registered", "You've been registered successfully");
        }

        return "loginTiles";
    }


    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDeniedTiles";
    }
}


