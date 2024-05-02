package com.example.springbook2.web.view;

import com.lowagie.text.Chapter;
import com.lowagie.text.Paragraph;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HelloPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Chapter chapter = new Chapter(new Paragraph("Spring Message"), 1);
        chapter.add(new Paragraph((String) map.get("message")));

        document.add(chapter);
    }
}
