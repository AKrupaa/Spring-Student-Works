package org.spring.plane.controller;

import org.spring.plane.domain.UserRole;
import org.spring.plane.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping(value = "/userRole")
    public String showUserRoles(Model model) {
        model.addAttribute("userRoleModel", new UserRole());
        model.addAttribute("presentUserRoles", userRoleService.listUserRoles());
        return "userRoleTiles";
    }

    @PostMapping(value = "/userRole")
    public String addRole(Model model, @ModelAttribute(value = "userRoleModel") UserRole userRole) {
        userRoleService.addUserRole(userRole);
        return "redirect:/";
    }

}
