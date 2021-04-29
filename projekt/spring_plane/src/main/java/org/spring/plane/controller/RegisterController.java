package org.spring.plane.controller;

import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.service.CustomUserService;
import org.spring.plane.validator.CustomUserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    CustomUserValidator customUserValidator = new CustomUserValidator();
    CustomUserService customUserService;

    public RegisterController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @GetMapping(value = "/register")
    public String register(Model model) {

        model.addAttribute("user", new CustomUserDomain());

        return "registerTiles";
    }

    @PostMapping(value = "/register")
    public String addUser(
            @ModelAttribute("user") CustomUserDomain user,
            Model model,
            BindingResult result,
            HttpServletRequest request) {
        customUserValidator.validate(user, result);

        if (result.getErrorCount() == 0) {

            if (customUserService.findByLogin(user.getLogin()) != null) {
                return "redirect:/login.html?alreadyExist";
            }

            customUserService.addCustomUser(user);
            return "redirect:/login.html?registered";
        }

        System.out.println();
        System.out.println();

        return "registerTiles";

    }
}
