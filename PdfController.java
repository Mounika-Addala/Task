package com.task.api.controller;

import com.itextpdf.text.DocumentException;
import com.task.api.service.PdfService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generatePdf")
    public ResponseEntity<byte[]> generatePdf() throws IOException {
        try {
            byte[] pdfContent = pdfService.generatePdfworkingcol("8b85b4b0-193a-467f-b4af-ad5de918ca5f");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "sample.pdf");
            return new ResponseEntity<>(pdfContent, headers, org.springframework.http.HttpStatus.OK);
        } catch (DocumentException e) {
            // Handle exception appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}









//@RestController
//@RequestMapping("/api")
//public class PdfController {
//
//    private final PdfService pdfService;
//
//    public PdfController(PdfService pdfService) {
//        this.pdfService = pdfService;
//    }
//
//    @GetMapping("/generatePdf/{orderId}")
////    public String generatePdfFromOrders(@RequestParam String id){
//    public ResponseEntity<?> generatePdfFromOrders(@PathVariable(name = "orderId") String orderId)
//    {
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream())
//        {
//            pdfService.generatePdfFromOrders(orderId, outputStream);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDispositionFormData("attachment", "orders.pdf");
//
//            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
//        } catch (IOException e) {
//            // Handle the exception, e.g., log it or return an error response
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
////        pdfService.generatePdfFromOrders(orderId);
//////        return "PDF generated Successfully";
////        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
//    }
//
