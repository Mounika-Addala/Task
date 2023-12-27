package com.task.api.controller;

import com.task.api.entity.Site;
import com.task.api.entity.StationaryItem;
import com.task.api.repository.StationaryItemRepo;
import com.task.api.service.ApiService;
import com.task.api.utility.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class MyController {

    private final ApiService apiService;
    private final StationaryItemRepo stationaryItemRepo;
	//private StationaryItemRepo StationaryItemRepo;
	private StationaryItemRepo StationaryItemRepo;

  // private MongoTemplate mongoTemplate;
    

	 //private final StationaryItemRepository stationaryItemRepository;

//	    @Autowired
//	    public  void MyController(StationaryItemRepo stationaryItemRepo) {
//	        this.StationaryItemRepo = stationaryItemRepo;
//	    }

    
//    @Autowired
//    public void setMongoTemplate(MongoTemplate mongoTemplate) {
//        this.apiService.setMongoTemplate(mongoTemplate);
//    }



    public MyController(ApiService apiService, StationaryItemRepo stationaryItemRepo) {
        this.apiService = apiService;
        this.stationaryItemRepo = stationaryItemRepo;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            InputStream excelFile = file.getInputStream();


            List<String> validationErrors = ExcelReader.checkValidationsExcel(excelFile);
            if (!validationErrors.isEmpty()) {
                String errorMessage = String.join(", ", validationErrors);
                return ResponseEntity.badRequest().body("Validation errors: " + errorMessage);
            }else {



//          String entitiestest = ExcelReader.checkValidationsExcel(excelFile);
//            if (entitiestest == null) {
//                return ResponseEntity.badRequest().body("Invalid data found in the Excel file");
//            }

                InputStream excelFile1 = file.getInputStream();

                List<StationaryItem> entities = ExcelReader.readFromExcel(excelFile1);
                stationaryItemRepo.saveAll(entities);
                return ResponseEntity.ok("Data inserted successfully");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error processing the Excel file");
        }
    }




    
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
//        try {
//            InputStream excelFile = file.getInputStream();
//            List<StationaryItem> entities = ExcelReader.readFromExcel(excelFile);
//            stationaryItemRepo.saveAll(entities);
//            return ResponseEntity.ok("Data inserted successfully");
//        }catch(IllegalArgumentException e){
//            return ResponseEntity.badRequest().body((e.getMessage()));
//        }
//
//        catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Error processing the Excel file");
//        }
//    }

//    List<String> validationErrors = ExcelReader.checkValidationsExcel(excelFile);
//            if (!validationErrors.isEmpty()) {
//        String errorMessage = String.join(", ", validationErrors);
//        return ResponseEntity.badRequest().body("Validation errors: " + errorMessage);
//    }else {
//
//
//
////          String entitiestest = ExcelReader.checkValidationsExcel(excelFile);
////            if (entitiestest == null) {
////                return ResponseEntity.badRequest().body("Invalid data found in the Excel file");
////            }
//
//        InputStream excelFile1 = file.getInputStream();
//
//        List<StationaryItem> entities = ExcelReader.readFromExcel(excelFile1);
//        stationaryItemRepo.saveAll(entities);
//        return ResponseEntity.ok("Data inserted successfully");
//    }
//
















    @GetMapping("/site")
    public ResponseEntity<List<Site>> getAllActiveSites() {
        List<Site> sites = apiService.getAllActiveSites();
        return new ResponseEntity<>(sites, HttpStatus.OK);
    }

    @GetMapping("/stationaryitems")
    public ResponseEntity<List<StationaryItem>> getAllStationary() {
        List<StationaryItem> stationaryItems = apiService.getAllStationary();
        return new ResponseEntity<>(stationaryItems, HttpStatus.OK);
    }
}



















//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Please select an Excel file to upload.");
//        }
//
//        apiService.processExcelFile(file);
//
//        return ResponseEntity.ok("File uploaded successfully.");







//@PostMapping("/add")
//    public ResponseEntity<?> addNewItem(@Valid @RequestBody StationaryItemRequest stationaryItemRequest, BindingResult result) {
//        if (result.hasErrors()) {
////            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
////            errorResponse.setMessage("Validation failed");
////            errorResponse.setErrors(result.getAllErrors().stream()
////                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
////                    .collect(Collectors.toList()));
//
//            return ResponseEntity.badRequest().body(new CustomErrorResponse(result.getAllErrors().get(0).getDefaultMessage()));
//        } else {
//            try
//            {
//            StationaryItem newItem = apiService.addNewItem(stationaryItemRequest);
//            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
//            }
//            catch(ResponseStatusException exc) {
//            	throw exc;
//            }
//            catch(Exception exc) {
//            	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exc.getMessage(),exc);
//            }
//            	//return ResponseEntity.badRequest().body(exc.getReason())  ;          }
//            }
//    }





//@PostMapping("/add")
//public ResponseEntity<?> addNewItem(@RequestBody StationaryItemRequest stationaryItemRequest) {
//  ResponseEntity<> newItem = apiService.addNewItem(stationaryItemRequest).getBody();
//  return ResponseEntity.ok(newItem);
//}


    //    @PostMapping("/add")
//    public StationaryItem addNewItem(@RequestBody StationaryItemRequest stationaryItemRequest){
//        return apiService.addNewItem(stationaryItemRequest);
//    }
//
//    @GetMapping("/active")
//    public ResponseEntity<List<Site>> getAllActiveSites() {
//        List<Site> activeSites = apiService.getAllActiveSites();
//        return new ResponseEntity<>(activeSites, HttpStatus.OK);
//
//    }




