package org.spring.plane.service;

import org.spring.plane.domain.CustomUserDomain;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(CustomUserDomain user, HttpServletResponse response);
}
