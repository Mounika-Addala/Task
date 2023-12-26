package com.task.api.controller;

import com.task.api.dto.ValidationErrorResponse;
import com.task.api.dto.StationaryItemRequest;
import com.task.api.entity.Site;
import com.task.api.entity.StationaryItem;
import com.task.api.exception.CustomErrorResponse;
import com.task.api.service.ApiService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Validated
public class MyController {

    private final ApiService apiService;

//    private MongoTemplate mongoTemplate;
    
    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.apiService.setMongoTemplate(mongoTemplate);
    }

//    public void MyController(MongoTemplate mongoTemplatete) {
//        this.mongoTemplate = mongoTemplate;
//    }

    public MyController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewItem(@Valid @RequestBody StationaryItemRequest stationaryItemRequest, BindingResult result) {
        if (result.hasErrors()) {
//            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
//            errorResponse.setMessage("Validation failed");
//            errorResponse.setErrors(result.getAllErrors().stream()
//                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                    .collect(Collectors.toList()));

            return ResponseEntity.badRequest().body(new CustomErrorResponse(result.getAllErrors().get(0).getDefaultMessage()));
        } else {
            try
            {
            StationaryItem newItem = apiService.addNewItem(stationaryItemRequest);
            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
            }
            catch(ResponseStatusException exc) {
            	throw exc;
            }
            catch(Exception exc) {
            	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exc.getMessage(),exc);
            }
            	//return ResponseEntity.badRequest().body(exc.getReason())  ;          }
            }
    }

 
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




