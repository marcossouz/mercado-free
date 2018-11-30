/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marco
 */
public class GeneratorPDF {

    Document document = new Document();
    DateFormat dateFormat = new SimpleDateFormat("HHmmssddMMyyyy");
    Date date = new Date();
    
    
    public String generatorPDF(String cupom) {
        
        String namePDF = dateFormat.format(date);
        try {

            PdfWriter.getInstance(document, new FileOutputStream( namePDF + ".pdf"));
            document.open();

            // adicionando um parágrafo no documento
            document.add(new Paragraph(cupom));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
        
        return namePDF;
    }
}
