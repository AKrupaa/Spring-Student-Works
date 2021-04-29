package pl.arkadiusz.service;

import org.springframework.stereotype.Service;
import pl.arkadiusz.domain.CarTypeDomain;
import pl.arkadiusz.domain.HistoryDomain;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pl.arkadiusz.utils.ParsingDateAndTime;

import java.io.IOException;

@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public void generatePdf(UserAuthenticationCoreDomain coreDomain, HistoryDomain historyDomain, HttpServletResponse response) {
        try {
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + coreDomain.getEmail() + ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("PDF file"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("FirsName");
            table.addCell(coreDomain.getUserDomain().getFirstName());
            table.addCell("LastName");
            table.addCell(coreDomain.getUserDomain().getLastName());
            table.addCell("Email");
            table.addCell(coreDomain.getEmail());
            for (CarTypeDomain carType : historyDomain.getCarDomain().getCarTypes()) {
                table.addCell("Car type");
                table.addCell(carType.getDescription());
            }
            table.addCell("Rented car name");
            table.addCell(historyDomain.getCarDomain().getName());
            table.addCell("Rental start date and time");
            table.addCell(historyDomain.getRentalStartDateAndTimeString());
            table.addCell("Rental end date and time");
            table.addCell(historyDomain.getRentalEndDateAndTimeString());
            table.addCell("Total costs");
            table.addCell(historyDomain.getCostsOfRental().toString());
            table.addCell("Date of invoice");
            ParsingDateAndTime parsingDateAndTime = new ParsingDateAndTime();
            table.addCell(parsingDateAndTime.parseDate(parsingDateAndTime.getActualDate()));
            pdf.add(table);
            pdf.close();
            o.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
