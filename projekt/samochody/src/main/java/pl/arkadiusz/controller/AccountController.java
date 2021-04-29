package pl.arkadiusz.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.domain.UserDomain;
import pl.arkadiusz.service.UserAuthenticationCoreService;
import pl.arkadiusz.service.UserService;

import java.security.Principal;

@Controller
public class AccountController {

    private final UserAuthenticationCoreService coreService;
    private final UserService userService;

    public AccountController(UserAuthenticationCoreService coreService, UserService userService) {
        this.coreService = coreService;
        this.userService = userService;
    }
//    modelUser

    //   show/edit users
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping(value = "/user")
    public String manageUsers(Model model, Principal principal) {

        UserAuthenticationCoreDomain userCoreDomain = null;
        try {
            userCoreDomain = coreService.getUserByEmail(principal.getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            return "redirect:/home";
        }

        UserDomain userDomain = null;

        try {
            userDomain = userCoreDomain.getUserDomain();
        } catch (NullPointerException npe) {
            model.addAttribute("modelUser", new UserDomain());
        }

        if (userDomain == null ){
            model.addAttribute("modelUser", new UserDomain());
        } else {
            model.addAttribute("modelUser", userDomain);
        }

//        if (userDomain.getTelephone().isEmpty()) {
//            model.addAttribute("modelUser", new UserDomain());
//        } else {
//            model.addAttribute("modelUser", userDomain);
//        }

        return "myAccountTiles";
    }


    // edit user
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @PostMapping(value = "/user")
    public String editUser(@ModelAttribute("modelUser") UserDomain user,
                           Model model,
                           Principal principal) {


//        System.out.println("\n");
        UserAuthenticationCoreDomain userCoreDomain = null;
        try {
            userCoreDomain = coreService.getUserByEmail(principal.getName());
        } catch (NullPointerException npe) {
            System.out.println(npe.fillInStackTrace().toString());
            return "redirect:/home";
        }

        // print what you got
        System.out.println();
        System.out.println(user.getId());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getTelephone());
        System.out.println();

//        edit this user, save in database
        userService.editUser(user);
        userCoreDomain.setUserDomain(user);
        coreService.editUserCore(userCoreDomain);

        return "redirect:/user";
    }
}
