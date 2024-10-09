package com.ghosttrio.smartfarmmanager.controller.batch.job.pdf.service;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


@Service
@RequiredArgsConstructor
public class CreateMemberDayActivityPdfService {


    public byte[] createPdf() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = setPdfConfig(outputStream);
        PdfFont customFont = createCustomFont();

        createHeader(document, customFont);
        createLine(document);
        createContent(document, customFont);

        document.close();
        outputStream.close();
        return outputStream.toByteArray();
    }

    private Document setPdfConfig(ByteArrayOutputStream outputStream) {
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        return new Document(pdfDoc, PageSize.A4);
    }

    private PdfFont createCustomFont() throws IOException {
        return PdfFontFactory.createFont("/GowunBatang-Regular.ttf", PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
    }

    private void createHeader(Document document, PdfFont customFont) {
        document.add(new Paragraph("header")
                .setFont(customFont)
                .setFontSize(20)  // H1 size
                .setBold()
                .setFontColor(ColorConstants.BLACK));
    }

    private void createLine(Document document) {
        LineSeparator lineSeparator = new LineSeparator(new SolidLine(1f)); // 1f for line thickness
        lineSeparator.setMarginTop(5);
        document.add(lineSeparator);
    }

    private void createContent(Document document, PdfFont customFont) {
    }

    private void createTable(Document document, PdfFont customFont) {
//        float[] columnWidths = {100F, 150F, 200F, 150F, 100F, 100F, 100F}; // Adjust as needed
//        document.add(new Paragraph(name)
//                .setFontSize(10)
//                .setBold()
//                .setFontColor(ColorConstants.BLACK)
//                .setFont(customFont));
//
//        Table table = new Table(columnWidths);
//
//        table.addHeaderCell(new Cell().add(new Paragraph("").setFont(customFont).setFontSize(10).setBold()));
//
//        for () {
//            table.addCell(new Cell().add(new Paragraph("").setFont(customFont).setFontSize(8)));
//        }
//
//        table.setTextAlignment(TextAlignment.CENTER);
//        table.setMarginTop(5);
//        document.add(table);
    }

}
