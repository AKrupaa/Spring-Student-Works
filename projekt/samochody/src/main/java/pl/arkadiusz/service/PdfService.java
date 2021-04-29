package pl.arkadiusz.service;

import pl.arkadiusz.domain.HistoryDomain;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {
    public void generatePdf(UserAuthenticationCoreDomain coreDomain, HistoryDomain historyDomain, HttpServletResponse response);
}
