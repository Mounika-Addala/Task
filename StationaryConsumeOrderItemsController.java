package com.task.api.controller;

import com.task.api.dto.StationaryConsumeOrderItemsDTO;
import com.task.api.entity.StationaryConsumeOrderItems;
import com.task.api.entity.StationaryConsumeOrders;
import com.task.api.service.StationaryConsumeOrderItemsService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import responseEntity.ErrorResponse;

@RestController
@RequestMapping("/api")

public class StationaryConsumeOrderItemsController {

  //  private  StationaryConsumeOrderItemsService stationaryConsumeOrderItemsService;
    
    private final StationaryConsumeOrderItemsService stationaryConsumeOrderItemsService;

    @Autowired
    public StationaryConsumeOrderItemsController(StationaryConsumeOrderItemsService stationaryConsumeOrderItemsService) {
        this.stationaryConsumeOrderItemsService = stationaryConsumeOrderItemsService;
    }

    
    
    @PostMapping("/consumeOrderItems")
    public ResponseEntity<?> addStationaryConsumeOrderItems(@Valid @RequestBody StationaryConsumeOrderItemsDTO scoitemsDTO, BindingResult result) {
        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            ErrorResponse responseMessage = new ErrorResponse("error", msg);
            return ResponseEntity.badRequest().body(responseMessage);
        }

        Object addOrderItems = stationaryConsumeOrderItemsService.saveStationaryConsumeOrderItemsLatest(scoitemsDTO);

        if (addOrderItems != null) {
            return ResponseEntity.ok(addOrderItems); // Return the added items if needed
        } else {
            ErrorResponse responseMessage = new ErrorResponse("error", "Failed to save consume order items");
            return ResponseEntity.badRequest().body(responseMessage);
        }
    }
//    @PostMapping("/consumeOrderItems")
//    public ResponseEntity<?> addStationaryConsumeOrderItems(@Valid @RequestParam StationaryConsumeOrderItemsDTO scoitemsDTO, BindingResult result){
//        if (result.hasErrors()) {
//            String msg = result.getFieldError().getDefaultMessage();
//            ErrorResponse responseMessage = new ErrorResponse("error", msg);
//            return ResponseEntity.badRequest().body(responseMessage);
//        }
//        StationaryConsumeOrderItems addOrderItems=stationaryConsumeOrderItemsService.saveStationaryConsumeOrderItems(scoitemsDTO);
//
////        StationaryConsumeOrders createdOrder = stationaryConsumeOrdersService.createStationaryConsumeOrder(scordersDTO);
////
////        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
////    }
//
//        return ResponseEntity.badRequest().body(addOrderItems);
//    }

}
