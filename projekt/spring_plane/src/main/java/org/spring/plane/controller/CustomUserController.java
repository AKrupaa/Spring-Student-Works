package org.spring.plane.controller;

import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.service.CustomUserService;
import org.spring.plane.service.UserRoleService;
import org.spring.plane.validator.CustomUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomUserController {

    private final CustomUserValidator customUserValidator = new CustomUserValidator();
    CustomUserService customUserService;
    UserRoleService userRoleService;

    @Autowired
    public CustomUserController(CustomUserService customUserService, UserRoleService userRoleService) {
        this.customUserService = customUserService;
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "/appUsers")
    public ModelAndView showAppUsers() {

	 /*  AppUser appUser = new AppUser();
	   appUser.setFirstName("rafal");
	   appUser.setLastName("kotas");
	   appUser.setEmail("rkotas@dmcs.pl");
	   appUser.setTelephone("123456789");*/

        return new ModelAndView("appUser", "appUser", new CustomUserDomain());
    }

    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@Valid @ModelAttribute("appUser") CustomUserDomain customUserDomain, BindingResult result, Model model) {

        System.out.println("First Name: " + customUserDomain.getFirstName() +
                " Last Name: " + customUserDomain.getLastName() + " Tel.: " + " Email: " + customUserDomain.getEmail());

        customUserValidator.validate(customUserDomain, result);

        if (result.getErrorCount() == 0) {
//            return
            System.out.println("brak bledow");
        }

        return "redirect:appUsers.html";
    }

    @GetMapping(value = "/manageUsers")
    public String manage(Model model) {
        model.addAttribute("presentUsers", customUserService.getUsers());

        return "manageUsersTiles";
//        model.addAttribute()
    }

    @GetMapping(value = "/user/edit/{userID}")
    public String edit(@PathVariable long userID, Model model) {

        CustomUserDomain customUserDomain = customUserService.getUser(userID);

        model.addAttribute("user", customUserDomain);
        model.addAttribute("roleList", userRoleService.listUserRoles());
        model.addAttribute("userRoles", customUserService.getUser(userID).getUserRoles());

//        customUserDomain.getUserRoles().

        return "editOneUserTiles";
    }

    @PostMapping(value = "/user/edit")
    public String editing(@ModelAttribute(value = "user") CustomUserDomain customUserDomain) {

        customUserDomain.setPassword(customUserService.findByLogin(customUserDomain.getLogin()).getPassword());
        customUserService.editCustomUser(customUserDomain);

        return "redirect:/manageUsers";
    }

    @GetMapping(value = "/user/delete/{userID}")
    public String delete(@PathVariable long userID) {

        customUserService.deleteCustomUser(userID);
        return "redirect:/manageUsers";
    }

    @GetMapping(value = "/user/toggle/{userID}")
    public String toggle(@PathVariable long userID) {

        CustomUserDomain customUserDomain = customUserService.getUser(userID);
        customUserDomain.setEnabled(!customUserDomain.isEnabled());
        customUserService.editCustomUser(customUserDomain);
        return "redirect:/manageUsers";
    }
}

