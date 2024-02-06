package com.task.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.api.dto.StationaryConsumeOrdersDTO;
import com.task.api.dto.UpdateOrderItemsDTO;
import com.task.api.dto.UpdateStationaryConsumeOrdersDTO;
import com.task.api.entity.StationaryConsumeOrders;
import com.task.api.service.StationaryConsumeOrdersService;

import jakarta.validation.Valid;
import responseEntity.ErrorResponse;

@RestController
@RequestMapping("/api")
public class StationaryConsumeOrdersController {
	
	
	
	private final StationaryConsumeOrdersService stationaryConsumeOrdersService;
	@Autowired
	public StationaryConsumeOrdersController(StationaryConsumeOrdersService stationaryConsumeOrderService, StationaryConsumeOrdersService stationaryConsumeOrdersService) {
		this.stationaryConsumeOrdersService = stationaryConsumeOrdersService;
	
	}
	@PostMapping("/addConsumeOrders")
	
	public ResponseEntity<?> createStationaryConsumeOrder(@Valid @RequestBody StationaryConsumeOrdersDTO scordersDTO, BindingResult result){
		
		 if (result.hasErrors()) {
	            String msg = result.getFieldError().getDefaultMessage();
	            ErrorResponse responseMessage = new ErrorResponse("error", msg);
	            return ResponseEntity.badRequest().body(responseMessage);
	        }
		 
		 StationaryConsumeOrders createdOrder = stationaryConsumeOrdersService.createStationaryConsumeOrder(scordersDTO);

	        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
	    }
 
//		 try {
//	            StationaryConsumeOrders createdOrder = stationaryConsumeOrdersService.createStationaryConsumeOrder(dto);
//	            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
//	        } catch (Exception e) {
//	            // Handle any exceptions or validation errors
//	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
	
//	@PutMapping("/updateConsumeOrders")
//	public ResponseEntity<?> updateStationaryConsumeOrder(@Valid @RequestBody StationaryConsumeOrdersDTO scOrdersDTO, BindingResult result){
//		
//		if(result.hasErrors())
//		{
//			String msg=result.getFieldError().getDefaultMessage();
//			ErrorResponse responseMessage=new ErrorResponse("error",msg);
//			return ResponseEntity.badRequest().body(responseMessage);
//		}
//		
//		 
//		StationaryConsumeOrders updateOrder=stationaryConsumeOrdersService. updateStationaryConsumeOrder(scOrdersDTO);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(updateOrder);
//		
//	}
	
	 @PutMapping("/stationaryconsumeorderstest/{orderId}")
	    public ResponseEntity<?> updateStationaryConsumeOrderTest(@PathVariable String orderId, @Valid @RequestBody StationaryConsumeOrdersDTO scOrderDTO) {
//	        if (result.hasErrors()) {
//	            String msg = result.getFieldError().getDefaultMessage();
//	            ErrorResponse responseMessage = new ErrorResponse("error", msg);
//	            return ResponseEntity.badRequest().body(responseMessage);
//	        }

	        // Convert DTO to entity and update
	        StationaryConsumeOrders updatedOrder = stationaryConsumeOrdersService.updateStationaryConsumeOrdernotUsed(orderId, scOrderDTO);

	        if (updatedOrder == null) {
	            ErrorResponse responseMessage = new ErrorResponse("error", "Stationary consume order not found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	        }

	        // Return the updated entity in the response
	        return ResponseEntity.ok(updatedOrder);
	 }
	 
	 

	    @PostMapping("/updateStationaryConsumeOrder")
	    public ResponseEntity<?> updateStationaryConsumeOrder(@Valid @RequestBody UpdateStationaryConsumeOrdersDTO updateStationaryConsumeOrdersDTO, BindingResult result) {

	        if (result.hasErrors()) {
	            String msg = result.getFieldError().getDefaultMessage();
	            ErrorResponse responseMessage = new ErrorResponse("error", msg);
	            return ResponseEntity.badRequest().body(responseMessage);
	        }

	        Object updatedOrder = stationaryConsumeOrdersService.updateStationaryConsumeOrder(updateStationaryConsumeOrdersDTO);

	        if (updatedOrder instanceof ErrorResponse) {
	            return ResponseEntity.badRequest().body(updatedOrder);
	        } else {
	            return ResponseEntity.ok(updatedOrder);
	        }
	    
	    }
	}


	


