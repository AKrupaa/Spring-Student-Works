package pl.arkadiusz.service;

import pl.arkadiusz.domain.AppUser;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(AppUser appUser, HttpServletResponse response);
}