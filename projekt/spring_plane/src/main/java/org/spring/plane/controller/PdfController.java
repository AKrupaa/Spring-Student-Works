package org.spring.plane.controller;

import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.service.CustomUserService;
import org.spring.plane.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_WORKER')")
public class PdfController {
    private final PdfService pdfService;
    private final CustomUserService userService;

    @Autowired
    public PdfController(PdfService pdfService, CustomUserService userService) {
        this.pdfService = pdfService;
        this.userService = userService;
    }

    @GetMapping(value = "/pdf")
    public void pdf(Model model, Principal principal, HttpServletResponse response) {

        CustomUserDomain user = userService.findByLogin(principal.getName());
        pdfService.generatePdf(user, response);
    }
}
