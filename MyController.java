package com.task.api.controller;

import com.task.api.dto.ValidationErrorResponse;
import com.task.api.dto.StationaryItemRequest;
import com.task.api.entity.Site;
import com.task.api.entity.StationaryItem;
import com.task.api.service.ApiService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MyController {
	 String UPLOAD_DIR = "D:/uploads/";
    private final ApiService apiService;

//    private MongoTemplate mongoTemplate;
//
//    public void MainController(MongoTemplate mongoTemplatete) {
//        this.mongoTemplate = mongoTemplate;
//    }
    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.apiService.setMongoTemplate(mongoTemplate);
    }

    public MyController(ApiService apiService) {
        this.apiService = apiService;
    }
    
    @PostMapping("/addUploadTest1")
    public ResponseEntity<?> addUploadTest1(
            @Valid  StationaryItemRequest stationaryItemRequest,
            @RequestParam("file") MultipartFile file,
            BindingResult result) {

        if (result.hasErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            errorResponse.setMessage("Validation failed");
            errorResponse.setErrors(result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList()));

            return ResponseEntity.badRequest().body(errorResponse);
        } else {
            String filePath = null;
            if (file.isEmpty()) {
                StationaryItem newItem = apiService.addNewItemUPload(stationaryItemRequest, filePath);
                return new ResponseEntity<>(newItem, HttpStatus.CREATED);
            } else {
                try {
                    File uploadDir = new File(UPLOAD_DIR);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }

                    String originalFilename = file.getOriginalFilename();
                    String[] fileNameSplit = originalFilename.split("\\.");
                    String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
                    filePath = UPLOAD_DIR + finalName;

                    file.transferTo(new File(filePath));
                    StationaryItem newItem = apiService.addNewItemUPload(stationaryItemRequest, filePath);
                    return new ResponseEntity<>(newItem, HttpStatus.CREATED);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
                }
            }
        }
    }

    @PostMapping("/addUploadTest")
    public ResponseEntity<?> addUploadTestbkp(
            @Valid @ModelAttribute StationaryItemRequest stationaryItemRequest,
            @RequestParam("file") MultipartFile file,
            BindingResult result) {

        if (result.hasErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            errorResponse.setMessage("Validation failed");
            errorResponse.setErrors(result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList()));

            return ResponseEntity.badRequest().body(errorResponse);
        } else {
        	String filePath = null;
            if (!file.isEmpty()) {
                
            try {
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String originalFilename = file.getOriginalFilename();
                String[] fileNameSplit = originalFilename.split("\\.");
                String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
                filePath = UPLOAD_DIR + finalName;

                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace(); 
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
            }
            }

           
            StationaryItem newItem = apiService.addNewItemUPload(stationaryItemRequest,filePath);
            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
        }
    }


//    @PostMapping("/addupload")
//    public ResponseEntity<?> addupload(@Valid @RequestBody StationaryItemRequest stationaryItemRequest, BindingResult result,@RequestParam("file") MultipartFile file) {
//
//    	String filePath1 =null;
//    	   if (file.isEmpty()) {
//
//           }else {
//
//
//               // Create the directory if it doesn't exist
//               File uploadDir = new File(UPLOAD_DIR);
//               if (!uploadDir.exists()) {
//                   uploadDir.mkdirs();
//               }
//
//               // Save the file to the specified directory on the D drive
//               String filePath = UPLOAD_DIR + file.getOriginalFilename();
//               String originalFilename = file.getOriginalFilename();
//             //  String[] fileNameSplit = file.getOriginalFilename().split(".");
//               String[] fileNameSplit = originalFilename.split("\\.");
//               String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
//                filePath1 = UPLOAD_DIR + finalName;
//           }
//       
//               try {
//				file.transferTo(new File(filePath1));
//			} catch (IllegalStateException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//           
//            StationaryItem newItem = apiService.addNewItemUPload(stationaryItemRequest,filePath1);
//            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
//           
//     //   }
//    }
//
//    
    
    

    @PostMapping("/add")
    public ResponseEntity<?> addNewItem(@Valid @RequestBody StationaryItemRequest stationaryItemRequest, BindingResult result) {
        if (result.hasErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            errorResponse.setMessage("Validation failed");
            errorResponse.setErrors(result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList()));

            return ResponseEntity.badRequest().body(errorResponse);
        } else {
            
            StationaryItem newItem = apiService.addNewItem(stationaryItemRequest);
            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
        }
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> addNewItem(@RequestBody StationaryItemRequest stationaryItemRequest) {
//        ResponseEntity<> newItem = apiService.addNewItem(stationaryItemRequest).getBody();
//        return ResponseEntity.ok(newItem);
//    }

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




