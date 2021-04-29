package org.spring.plane.service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.spring.plane.domain.CustomUserDomain;
import org.spring.plane.domain.Ticket;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public void generatePdf(CustomUserDomain user, HttpServletResponse response) {
        try {
            OutputStream o = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + user.getEmail() + ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("PDF file"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("First name");
            table.addCell(user.getFirstName());
            table.addCell("Last name");
            table.addCell(user.getLastName());
            table.addCell("Email");
            table.addCell(user.getEmail());
            table.addCell("Tickets");
            for (Ticket ticket : user.getTickets()) {
                table.addCell("Name");
                table.addCell(ticket.getAirplane().getName());
                table.addCell("From");
                table.addCell(ticket.getAirplane().getSource());
                table.addCell("To");
                table.addCell(ticket.getAirplane().getDestination());
                table.addCell("Departure");
                table.addCell(ticket.getAirplane().getDeparture().toString());
                table.addCell("arrival");
                table.addCell(ticket.getAirplane().getDeparture().toString());
                table.addCell("Price");
                table.addCell(String.valueOf(ticket.getPrice()));
            }
            pdf.add(table);
            pdf.close();
            o.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
