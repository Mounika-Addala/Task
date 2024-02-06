package com.task.api.controller;


import com.task.api.dto.OrderRequest;
import com.task.api.entity.Orders;
import com.task.api.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import responseEntity.ErrorResponse;
import responseEntity.SuccessResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    String UPLOAD_DIR = "D:/uploads/";
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping("/addOrder")
//    public ResponseEntity<?> addNewOrderbkp(@Valid @RequestBody Orders orderRequest, BindingResult result) {
//        if (result.hasErrors()) {
//            String errorMessage = result.getFieldError("vendorName").getDefaultMessage();
//            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//        }
//
//        if (result.hasErrors()) {
//
//            for (FieldError error : result.getFieldErrors()) {
//                String fieldName = error.getField();
//                String defaultMessage = error.getDefaultMessage();
//
//                switch (fieldName) {
//                    case "vendorName":
//                        return new ResponseEntity<>("Please enter vendor name", HttpStatus.BAD_REQUEST);
//                    case "poNumber":
//                        return new ResponseEntity<>("Please enter PO number", HttpStatus.BAD_REQUEST);
//                    case "siteName":
//                    case "siteId":
//                        return new ResponseEntity<>("Please enter site details", HttpStatus.BAD_REQUEST);
//                    case "invoiceDate":
//                        return new ResponseEntity<>("Please enter invoice date", HttpStatus.BAD_REQUEST);
//
//                }
//            }
//
//        }
//            Orders newOrder = orderService.newOrder(orderRequest);
//            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//
//        }
//
//    

    // @PostMapping("/addOrder")
//    public ResponseEntity<?> addNewOrder(@RequestParam("file") MultipartFile file, @Valid @ModelAttribute OrderRequest orderRequest, BindingResult result) {
//        // ...
//        return new ResponseEntity<>("test", HttpStatus.CREATED);

    @PostMapping("/addOrdertest")
    public ResponseEntity<?> addOrdertest(@RequestParam("file") MultipartFile file, @Valid OrderRequest orderRequest,  BindingResult result) {
        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            ErrorResponse responseMessage= new ErrorResponse ("error",msg);
            return  ResponseEntity.badRequest().body(responseMessage);
        }


        System.out.println("Received file: " + file.getOriginalFilename());
        System.out.println("Received orderRequest: " + orderRequest);

//        if (result.hasErrors()) {
//
//            List<String> errorMessages = new ArrayList<>();
//
//            for (FieldError error : result.getFieldErrors()) {
//                String fieldName = error.getField();
//                // String defaultMessage = error.getDefaultMessage();
//
//                switch (fieldName) {
//                    case "vendorName":
//                        return new ResponseEntity<>("Please enter vendor name", HttpStatus.BAD_REQUEST);
//                    //      	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"error\", \"message\": \"Please enter vendor name\"}");
//                    case "poNumber":
//                        return new ResponseEntity<>("Please enter PO number", HttpStatus.BAD_REQUEST);
//                    case "siteName":
//                    case "siteId":
//                        return new ResponseEntity<>("Please enter site details", HttpStatus.BAD_REQUEST);
//                    case "invoiceDate":
//                        return new ResponseEntity<>("Please enter invoice date", HttpStatus.BAD_REQUEST);
//
//                }
//            }
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.join(", ", errorMessages));
  //      }

        // String filePath = null;


        if (!file.isEmpty()) {
            // File format validation
            String originalFilename = file.getOriginalFilename();
            String[] fileNameSplit = originalFilename.split("\\.");
            String fileExtension = fileNameSplit.length > 1 ? fileNameSplit[1] : "";


//           List<String> allowedFileFormats = Arrays.asList("pdf", "jpg", "png");
//
//            if (!allowedFileFormats.contains(fileExtension.toLowerCase())) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file format. Allowed formats: " + String.join(", ", allowedFileFormats));
//            }

            String filePath;

            try {
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileExtension;
                filePath = UPLOAD_DIR + finalName;

                file.transferTo(new File(filePath));

                Orders newOrder = orderService.newOrderTest(orderRequest, filePath);
               // return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
                SuccessResponse responseMessage=new SuccessResponse("success","order created successfully",newOrder);
                return ResponseEntity.ok().body(responseMessage);

            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
            }
        } else {
            Orders newOrder = orderService.newOrderTest(orderRequest, null);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        }
    }

    @GetMapping("/getOrderDetails")
    public ResponseEntity<List<Orders>> getAllOrders () {
        List<Orders> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

//        if(file.isEmpty()){
//            Orders newOrder = orderService.newOrderTest(orderRequest,filePath);
//            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//
//        }else{
//
//    try {
//        File uploadDir = new File(UPLOAD_DIR);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdirs();
//        }
//
//        String originalFilename = file.getOriginalFilename();
//        String[] fileNameSplit = originalFilename.split("\\.");
//        String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
//        filePath = UPLOAD_DIR + finalName;
//
//        file.transferTo(new File(filePath));
//                     Orders newOrder = orderService.newOrderTest(orderRequest,filePath);
//                     return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//
//    } catch (IOException e) {
//        e.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
//    }
//}
//
//   }

//

//    @PostMapping("/addOrder")
//    public ResponseEntity<?> addNewOrderbkp(@Valid @RequestBody OrderRequest orderRequest, BindingResult result) {
//        if (result.hasErrors()) {
//            String errorMessage = result.getFieldError("vendorName").getDefaultMessage();
//            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//        }
//
//        if (result.hasErrors()) {
//
//            for (FieldError error : result.getFieldErrors()) {
//                String fieldName = error.getField();
//                String defaultMessage = error.getDefaultMessage();
//
//                switch (fieldName) {
//                    case "vendorName":
//                        return new ResponseEntity<>("Please enter vendor name", HttpStatus.BAD_REQUEST);
//                    case "poNumber":
//                        return new ResponseEntity<>("Please enter PO number", HttpStatus.BAD_REQUEST);
//                    case "siteName":
//                    case "siteId":
//                        return new ResponseEntity<>("Please enter site details", HttpStatus.BAD_REQUEST);
//                    case "invoiceDate":
//                        return new ResponseEntity<>("Please enter invoice date", HttpStatus.BAD_REQUEST);
//
//                }
//            }
//
//        }
//            Orders newOrder = orderService.newOrder(orderRequest);
//            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//
//        }

    
    
  //  @PostMapping("/addNewOrdersample")
//    public ResponseEntity<?> addNewOrdersample(
//            @Valid OrderRequest orderRequest,
//            @RequestParam(name = "file", required = false) MultipartFile file,
//            BindingResult result) {
//
//        if (result.hasErrors()) {
//            for (FieldError error : result.getFieldErrors()) {
//                switch (error.getField()) {
//                    case "vendorName":
//                        return new ResponseEntity<>("Please enter vendor name", HttpStatus.BAD_REQUEST);
//                    case "poNumber":
//                        return new ResponseEntity<>("Please enter PO number", HttpStatus.BAD_REQUEST);
//                    case "siteName":
//                    case "siteId":
//                        return new ResponseEntity<>("Please enter site details", HttpStatus.BAD_REQUEST);
//                    case "invoiceDate":
//                        return new ResponseEntity<>("Please enter invoice date", HttpStatus.BAD_REQUEST);
//                    default:
//                        return new ResponseEntity<>(error.getDefaultMessage(), HttpStatus.BAD_REQUEST);
//                }
//            }
//        }
//
//        String filePath = null;
//        if (file != null && !file.isEmpty()) {
//            try {
//                File uploadDir = new File(fileDir);
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdirs();
//                }
//
//                String originalFilename = file.getOriginalFilename();
//                String[] fileNameSplit = originalFilename.split("\\.");
//                String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
//                filePath = fileDir + finalName;
//
//                file.transferTo(new File(filePath));
//            } catch (IOException e) {
//                e.printStackTrace();
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
//            }
//        }
//
//        Orders newOrder = orderService.newOrder(orderRequest, filePath);
//        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//    }
//
//    
    
//    @PostMapping("/addNewOrdersample")
//    public ResponseEntity<?> addNewOrdersample(@Valid  OrderRequest orderRequest,@RequestParam("file") MultipartFile file, BindingResult result) {
//        if (result.hasErrors()) {
//            String errorMessage = result.getFieldError("vendorName").getDefaultMessage();
//            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//        }
//
//        
//        
//        
//        
//        
//        if (result.hasErrors()) {
//
//            for (FieldError error : result.getFieldErrors()) {
//                String fieldName = error.getField();
//                String defaultMessage = error.getDefaultMessage();
//
//                switch (fieldName) {
//                    case "vendorName":
//                        return new ResponseEntity<>("Please enter vendor name", HttpStatus.BAD_REQUEST);
//                    case "poNumber":
//                        return new ResponseEntity<>("Please enter PO number", HttpStatus.BAD_REQUEST);
//                    case "siteName":
//                    case "siteId":
//                        return new ResponseEntity<>("Please enter site details", HttpStatus.BAD_REQUEST);
//                    case "invoiceDate":
//                        return new ResponseEntity<>("Please enter invoice date", HttpStatus.BAD_REQUEST);
//
//                }
//            }
//
//        } else {
//            String filePath = null;
//            if (file.isEmpty()) {
//            	Orders newOrder = orderService.newOrder(orderRequest,filePath);
//                return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//            } else {
//                try {
//                    File uploadDir = new File(fileDir);
//                    if (!uploadDir.exists()) {
//                        uploadDir.mkdirs();
//                    }
//
//                    String originalFilename = file.getOriginalFilename();
//                    String[] fileNameSplit = originalFilename.split("\\.");
//                    String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
//                    filePath = fileDir + finalName;
//
//                    file.transferTo(new File(filePath));
//                    Orders newOrder = orderService.newOrder(orderRequest);
//                    return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
//                }
////            Orders newOrder = orderService.newOrder(orderRequest,);
////            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//            }
//        }
//    }





   // return ResponseEntity.ok("Order added successfully");



















//        if (bindingResult.hasErrors()) {
//            // Validation errors occurred
//            List<String> errors = new ArrayList<>();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errors.add(error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(new ApiResponse(false, "Validation errors", errors), HttpStatus.BAD_REQUEST);
//        }
//
//        // Proceed with order creation
//        orderDTO.setFile(file);
//        orderService.createOrder(orderDTO);
//
//        return new ResponseEntity<>(new ApiResponse(true, "Order created successfully"), HttpStatus.OK);
//    }






























//    @PostMapping("/add")
//    public ResponseEntity<?> addNewItem(@Valid @RequestBody StationaryItemRequest stationaryItemRequest, BindingResult result) {
//        if (result.hasErrors()) {
//
//            return ResponseEntity.badRequest().body(new CustomErrorResponse(result.getAllErrors().get(0).getDefaultMessage()));
//        } else {
//            try
//            {
//                StationaryItem newItem = apiService.addNewItem(stationaryItemRequest);
//                return new ResponseEntity<>(newItem, HttpStatus.CREATED);
//            }
//            catch(ResponseStatusException exc) {
//                throw exc;
//            }
//            catch(Exception exc) {
//                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exc.getMessage(),exc);
//            }
//            //return ResponseEntity.badRequest().body(exc.getReason())  ;          }
//        }



//    catch(MethodArgumentNotValidException ex){
//        return handleValidationErrors(ex);
//    }

//    private ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getFieldErrors().stream()
//                .map(error -> error.getField() + ": " + error.getDefaultMessage())
//                .toList();
//
//        return new ResponseEntity<>(new ApiResponse(false, "Validation errors", errors), HttpStatus.BAD_REQUEST);
//    }