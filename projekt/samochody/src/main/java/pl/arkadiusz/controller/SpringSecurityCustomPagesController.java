package pl.arkadiusz.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;
import pl.arkadiusz.service.ReCaptchaService;
import pl.arkadiusz.service.UserAuthenticationCoreService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller

public class SpringSecurityCustomPagesController {

    UserAuthenticationCoreService service;
    ReCaptchaService reCaptchaService;

    public SpringSecurityCustomPagesController(UserAuthenticationCoreService service, ReCaptchaService reCaptchaService) {
        this.service = service;
        this.reCaptchaService = reCaptchaService;
    }

    @RequestMapping(value = "/login")
    public String customLogin(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              Model model,
                              HttpServletRequest request) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println(authentication.isAuthenticated());
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();

        if (error != null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout != null) {
            model.addAttribute("Information", "You've been logged out successfully");
        }

        model.addAttribute("modelRegister", new UserAuthenticationCoreDomain());
        return "RegisterOrLoginTiles";
    }


    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDeniedTiles";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("modelRegister") UserAuthenticationCoreDomain user,
                           Model model,
//                           BindingResult result,
                           HttpServletRequest request) {

        System.out.println();
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.isEnabled());
        System.out.println();

//        if(result.hasErrors()) {
//            return "RegisterOrLoginTiles";
//        }

        if (service.getUserByEmail(user.getEmail()) != null) {
            model.addAttribute("Information", "Email is already taken!");
            return "RegisterOrLoginTiles";
        }

        if (reCaptchaService.verify(request.getParameter("g-recaptcha-response"))) {
            user.setEnabled(true);
            service.addUserCore(user);
            return "redirect:/welcome/register";
        } else {
            model.addAttribute("Information", "Are you a robot?");
            return "RegisterOrLoginTiles";
        }
    }

}


