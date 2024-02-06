package com.task.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.api.dto.OrderItemsDTONew;
import com.task.api.service.ExcelService;
import com.task.api.service.OrderItemsService;

import jakarta.validation.Valid;
import responseEntity.ErrorResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
//
//@RestController
//@RequestMapping("/excel")
//public class ExcelController {
//
//   
//  // final OrderItemsService orderItemsService;
//
//    @Autowired
//    private ExcelService excelService;
//
//    @GetMapping("/generateOrders")
//    public void generateExcelFromOrders()  {
////        List<orderitems> existingOrders = ordersRepo.findAll(); // Change this based on your query
////        excelService.generateExcelFromOrders(existingOrders, response);
//     
//
//        Object orderItems = excelService.generateExcelFromOrders();
//
//      
//    }
//    
//
//  
//}
//

import org.apache.poi.ss.usermodel.Workbook;

@RestController
@RequestMapping("/api")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/generateOrders/{orderId}")
    public ResponseEntity<byte[]> generateExcelFromOrders(
            @PathVariable(name = "orderId") String orderId) {
        // You can use the 'orderId' parameter to pass data from the URL path

        Workbook workbook = excelService.generateExcelFromOrders(orderId);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "orders.xlsx");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (IOException e) {
            // Handle the exception, e.g., log it or return an error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                // Log or handle the workbook closing exception
            }
        }
    }
}


























//
//    @GetMapping("/generateOrders/{orderId}")
//    public ResponseEntity<byte[]> generateExcelFilesFromOrders(
//            @PathVariable(name = "orderId") String orderId) {
//
//        Workbook workbook1 = excelService.generateExcelFromOrders(orderId, "orders1.xlsx");
//        Workbook workbook2 = excelService.generateExcelFromOrders(orderId, "orders2.xlsx");
//
//        try (ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
//             ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream()) {
//
//            workbook1.write(outputStream1);
//            workbook2.write(outputStream2);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//            // Create a Map to hold the byte arrays and file names
//            Map<String, byte[]> excelFilesMap = new HashMap<>();
//            excelFilesMap.put("orders1.xlsx", outputStream1.toByteArray());
//            excelFilesMap.put("orders2.xlsx", outputStream2.toByteArray());
//
//            return new ResponseEntity<>(excelFilesMap, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        } finally {
//            try {
//                workbook1.close();
//                workbook2.close();
//            } catch (IOException e) {
//                // Log or handle the workbook closing exception
//            }
//        }
//    }
//}


//        Workbook workbook1 = excelService.generateExcelFromOrders(orderId, "orders1.xlsx");
//        Workbook workbook2 = excelService.generateExcelFromOrders(orderId, "orders2.xlsx");
//
//        try (ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
//             ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream()) {
//
//            workbook1.write(outputStream1);
//            workbook2.write(outputStream2);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
//            headers.setContentDispositionFormData("attachment", "orders1.xlsx");
//
//            // Combine both Excel files into a byte array
//            byte[] combinedBytes = combineByteArrays(outputStream1.toByteArray(), outputStream2.toByteArray());
//
//            return new ResponseEntity<>(combinedBytes, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        } finally {
//            try {
//                workbook1.close();
//                workbook2.close();
//            } catch (IOException e) {
//                // Log or handle the workbook closing exception
//            }
//        }
//    }
//
//    private byte[] combineByteArrays(byte[] array1, byte[] array2) {
//        byte[] combined = new byte[array1.length + array2.length];
//        System.arraycopy(array1, 0, combined, 0, array1.length);
//        System.arraycopy(array2, 0, combined, array1.length, array2.length);
//        return combined;
//    }
//}







    /* getting 2 excel files in one zip file */

//    @GetMapping("/generateOrders/{orderId}")
//    public ResponseEntity<byte[]> generateExcelFilesFromOrders(
//            @PathVariable(name = "orderId") String orderId) {
//        Workbook workbook1 = excelService.generateExcelFromOrders(orderId, "orders1.xlsx");
//        Workbook workbook2 = excelService.generateExcelFromOrders(orderId, "orders2.xlsx");
//
//        try (ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
//             ZipOutputStream zipFile = new ZipOutputStream(zipOutputStream)) {
//
//            addToZip(zipFile, workbook1, "orders1.xlsx");
//            addToZip(zipFile, workbook2, "orders2.xlsx");
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.parseMediaType("application/zip"));
//            headers.setContentDispositionFormData("attachment", "orders.zip");
//
//            return new ResponseEntity<>(zipOutputStream.toByteArray(), headers, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        } finally {
//            try {
//                workbook1.close();
//                workbook2.close();
//            } catch (IOException e) {
//                // Log or handle the workbook closing exception
//            }
//        }
//    }
//
//    private void addToZip(ZipOutputStream zipFile, Workbook workbook, String fileName) throws IOException {
//        try (ByteArrayOutputStream excelOutputStream = new ByteArrayOutputStream()) {
//            workbook.write(excelOutputStream);
//            ZipEntry zipEntry = new ZipEntry(fileName);
//            zipFile.putNextEntry(zipEntry);
//            zipFile.write(excelOutputStream.toByteArray());
//            zipFile.closeEntry();
//        }
//    }
//}


   /* only for one excel file */







//    @GetMapping("/generateOrders")
//    public ResponseEntity<byte[]> generateExcelFromOrders(@Valid @RequestBody ExcelDTO: ExcelDTO, BindingResult result) {
//        Workbook workbook = excelService.generateExcelFromOrders();
//
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
//            workbook.write(outputStream);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
//            headers.setContentDispositionFormData("attachment", "orders.xlsx");
//
//            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
//        } catch (IOException e) {
//            // Handle the exception, e.g., log it or return an error response
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        } finally {
//            try {
//                workbook.close();
//            } catch (IOException e) {
//                // Log or handle the workbook closing exception
//            }
//        }
//    }
//}


