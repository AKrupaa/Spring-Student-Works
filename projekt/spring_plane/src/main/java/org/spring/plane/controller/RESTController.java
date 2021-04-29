package org.spring.plane.controller;

import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/REST")
public class RESTController {

    CustomUserService userService;

    @Autowired
    public RESTController(CustomUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{login}.json", produces = "application/json")
    public CustomUserDomain getUserInfoInJson(@PathVariable String login) {
        return this.userService.findByLogin(login);
    }

    @GetMapping(value = "/{login}.xml", produces = "application/xml")
    public CustomUserDomain getUserInfoInXML(@PathVariable String login) {
        return this.userService.findByLogin(login);
    }

}
