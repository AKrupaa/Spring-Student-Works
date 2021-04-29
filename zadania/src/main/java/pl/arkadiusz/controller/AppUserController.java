package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.arkadiusz.domain.AppUser;
import pl.arkadiusz.domain.UserAddress;
import pl.arkadiusz.service.AddressService;
import pl.arkadiusz.service.AppUserRoleService;
import pl.arkadiusz.service.AppUserService;
import pl.arkadiusz.service.ReCaptchaService;
import pl.arkadiusz.validator.AppUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AppUserController {

    // dodajemy serwis
    private final AppUserService appUserService;
    private final AddressService addressService;
    private final AppUserRoleService appUserRoleService;
    private final ReCaptchaService reCaptchaService;

    // obiekt do walidacji
    private AppUserValidator appUserValidator = new AppUserValidator();

    @Autowired
    public AppUserController(AppUserService appUserService, AddressService addressService, AppUserRoleService appUserRoleService, ReCaptchaService reCaptchaService) {
        this.appUserService = appUserService;
        this.addressService = addressService;
        this.appUserRoleService = appUserRoleService;
        this.reCaptchaService = reCaptchaService;
    }

    @RequestMapping(value = "/appUsers")
    public String showAppUsers(Model model, HttpServletRequest request) {
        long appUserId = ServletRequestUtils.getLongParameter(request, "appUserId", -1);

        if (appUserId > 0) {
            AppUser appUser = appUserService.getAppUser(appUserId);
            UserAddress userAddress = addressService.getUserAddress(appUser.getUserAddress().getId());
            appUser.setUserAddress(userAddress);
            model.addAttribute("selectedAddress", userAddress);
            model.addAttribute("appUser", appUser);
        } else {
            model.addAttribute("appUser", new AppUser());
        }

        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("addressesList", addressService.getUsersAddresses());
        model.addAttribute("appUserRoleList", appUserRoleService.listAppUserRoles());

        return "appUser";
    }

    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model, HttpServletRequest request) {
        System.out.println("First Name " + appUser.getFirstName() + "Last Name " + appUser.getLastName()
                + "Tel " + appUser.getTelephone() + "Email " + appUser.getEmail());

        appUserValidator.validate(appUser, result);

        if(result.getErrorCount() == 0 && reCaptchaService.verify(request.getParameter("g-recaptcha-response"))) {
            if (appUser.getId() == 0) {
                appUserService.addAppUser(appUser);
            } else {
                appUserService.editAppUser(appUser);
            }

        return "redirect:/appUsers.html";
        }
        // jak nie zwaliduje poprawnie to zwroc do strony internetowej liste uzytkownikow
        model.addAttribute("appUserList", appUserService.listAppUser());
        // przejdz ponownie do tej strony internetowej.
        return "appUser";
    }

    @RequestMapping("/delete/{appUserId}")
    public String deleteUser(@PathVariable("appUserId") long appUserId) {
        appUserService.removeAppUser(appUserId);
        return "redirect:/appUsers.html";
    }

    // old one, nice try

    //    @RequestMapping(value = "/appUsers")
//    public ModelAndView showAppUsers() {
//
//        return new ModelAndView("appUser", "appUser", new AppUser());
//    }
//
//    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
//    public String addAppUser(@ModelAttribute("appUser") AppUser appUser) {
//        System.out.println("First Name " + appUser.getFirstName() + "Last Name " + appUser.getLastName()
//                + "Tel " + appUser.getTelephone() + "Email " + appUser.getEmail());
//
//        return "redirect:appUsers.html";
//    }

}
