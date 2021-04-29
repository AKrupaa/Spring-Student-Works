package pl.arkadiusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arkadiusz.domain.CarDomain;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.domain.UserDomain;
import pl.arkadiusz.service.UserAuthenticationCoreService;
import pl.arkadiusz.service.UserService;

@Controller
public class ManageUsersController {

    private long editUserId = -1;
    private final UserAuthenticationCoreService userCoreService;

    @Autowired
    public ManageUsersController(UserAuthenticationCoreService userCoreService) {
        this.userCoreService = userCoreService;
    }

    //   show/edit users
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/manageUsers")
    public String manageUsers(Model model) {

        if (editUserId > 0) {
            model.addAttribute("modelUserCore", userCoreService.getUserById(editUserId));
        } else
            model.addAttribute("modelUserCore", new UserAuthenticationCoreDomain());

        model.addAttribute("modelUserCoreList", userCoreService.getUsers());
        this.editUserId = -1;

        return "manageUsersTiles";
    }

    // delete user
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/delete/user/{userID}")
    public String deleteUser(@PathVariable(value = "userID") long userID) {
        userCoreService.deleteUserCoreById(userID);
        return "redirect:/manageUsers";
    }

    // edit user
    @Secured("ROLE_ADMIN" )
    @GetMapping(value = "/edit/user/{userID}")
    public String editUser(@PathVariable(value = "userID") long userID) {
        editUserId = userID;
        return "redirect:/manageUsers";
    }


    // add user or edit.
    @Secured("ROLE_ADMIN" )
    @PostMapping(value = "/add/userrrr")
    public String addfUser(@ModelAttribute("modelUserCore") UserAuthenticationCoreDomain user, Model model) {

        // print what you got
        System.out.println();
        System.out.println(user.getId());
        System.out.println(user.getEmail());
//        System.out.println(user.getHistoryDomains());
        System.out.println(user.getUserDomain().getFirstName());
        System.out.println(user.getUserDomain().getLastName());
        System.out.println(user.getUserDomain().getTelephone());
//        System.out.println(car.getSourceImage());
//        System.out.println(car.isRented());
        System.out.println();

//        add new user
        if (user.getId() == 0) {
            userCoreService.addUserCore(user);
        } else if (user.getId() > 0) {
            user.setHistoryDomains(userCoreService.getUserById(user.getId()).getHistoryDomains());
            userCoreService.editUserCore(user);
        }

        return "redirect:/manageUsers";
    }
}
