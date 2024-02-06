package com.task.api.controller;

import com.itextpdf.text.DocumentException;
import com.task.api.service.ExcelService;
import com.task.api.service.PdfService;
import com.task.api.service.WordService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class DocumentController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    private PdfService pdfService;
    @Autowired
    private WordService wordService;

    @GetMapping("/generateDocument/{format}/{id}")
    public ResponseEntity<byte[]> generateDocument(
            @PathVariable(name="format") String format,
            @PathVariable(name="id") String id) throws IOException, DocumentException {

        try {
            byte[] documentContent;
            HttpHeaders headers = new HttpHeaders();

            if ("pdfMul".equalsIgnoreCase(format)) {
                documentContent = pdfService.generatePdfworkingcol(id);
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("inline", "sample.pdf");
            }else if ("pdf".equalsIgnoreCase(format)) {
                documentContent = pdfService.generatePdfworkingcolsingle(id);
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("inline", "sample.pdf");
            }
            else if ("pdfanother".equalsIgnoreCase(format)) {
                documentContent = pdfService.generatePdfworkingcolsingleAnother(id);
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("inline", "sample.pdf");
            } else if ("pdfanothernew".equalsIgnoreCase(format)) {
                documentContent = pdfService.generatePdfworkingcolsingleAnotherNew(id);
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("inline", "sample.pdf");
            }
            else if ("excel".equalsIgnoreCase(format)) {
                Workbook workbook = excelService.generateExcelFromOrders(id);
                documentContent = writeWorkbookToByteArray(workbook);
                headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
                headers.setContentDispositionFormData("attachment", "orders.xlsx");
                workbook.close();
            }  else if ("word".equalsIgnoreCase(format)) {

                documentContent = wordService.generateWordDocument2(id);
                headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
                headers.setContentDispositionFormData("attachment", "sample.docx");
//                headers.setContentType(MediaType.APPLICATION_MS_WORD);
//                headers.setContentDispositionFormData("attachment", "sample.docx");
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(documentContent, headers, HttpStatus.OK);
        } catch (DocumentException | IOException exception ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        return null;
    }
    private byte[] writeWorkbookToByteArray(Workbook workbook) throws IOException {
            try(ByteArrayOutputStream outputStream=new ByteArrayOutputStream()){
                workbook.write(outputStream);
                return outputStream.toByteArray();
            }
        }
    }


