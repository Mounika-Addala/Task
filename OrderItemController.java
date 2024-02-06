package com.task.api.controller;

import com.task.api.dto.OrderItemsDTO;
import com.task.api.dto.OrderItemsDTONew;
import com.task.api.dto.OrderItemsRequest;
import com.task.api.dto.UpdateOrderItemsDTO;
import com.task.api.entity.OrderItems;
import com.task.api.service.OrderItemsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import responseEntity.ErrorResponse;
import responseEntity.SuccessResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderItemController {
    private final OrderItemsService orderItemsService;

    public OrderItemController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }


    @PostMapping("/addOrderItemTestObjnew")
    public ResponseEntity<?> addOrderItemTestObjnew(@Valid @RequestBody OrderItemsDTONew orderItemsDTONew, BindingResult result) {
//        if (result.hasErrors()) {
//            String msg = result.getFieldError().getDefaultMessage();
//            ErrorResponse responseMessage = new ErrorResponse("error", msg);
//            return ResponseEntity.badRequest().body(responseMessage);
//        }
//
//        Object orderItems = orderItemsService.addNewItemTestObj(orderItemsDTO);
//        return new ResponseEntity<>(orderItems, HttpStatus.CREATED);

        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            ErrorResponse responseMessage = new ErrorResponse("error", msg);
            return ResponseEntity.badRequest().body(responseMessage);
        }

        Object orderItems = orderItemsService.addNewItemTestObjNEW(orderItemsDTONew);

        if (orderItems instanceof ErrorResponse) {
            return ResponseEntity.badRequest().body(orderItems);
        } else {
            return ResponseEntity.ok(orderItems);
        }
    }

    @PostMapping("/updateOrderItems")
    public ResponseEntity<?> updateOrderItems(@Valid @RequestBody UpdateOrderItemsDTO updateOrderItemsDTO, BindingResult result) {

        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            ErrorResponse responseMessage = new ErrorResponse("error", msg);
            return ResponseEntity.badRequest().body(responseMessage);
        }

        Object orderItems = orderItemsService.updateOrderItems(updateOrderItemsDTO);

        if (orderItems instanceof ErrorResponse) {
            return ResponseEntity.badRequest().body(orderItems);
        } else {
            return ResponseEntity.ok(orderItems);
        }
    }

    @GetMapping("/getAllOrderItems")
    public ResponseEntity<?> getAllOrderItems(
            @Valid OrderItemsRequest orderItemsRequest,
            Errors errors) {

        if (errors.hasErrors()) {
            String msg = errors.getFieldError().getDefaultMessage();
            ErrorResponse responseMessage = new ErrorResponse("error", msg);
            return ResponseEntity.badRequest().body(responseMessage);
        }

        try {
            List<OrderItems> orderItems;
            if (orderItemsRequest.getOrderId() != null && orderItemsRequest.getItemId() != null) {
                orderItems = orderItemsService.getByOrderIdAndItemId(orderItemsRequest.getOrderId(), orderItemsRequest.getItemId());
            } else if (orderItemsRequest.getOrderId() != null) {

                if (!orderItemsService.doesOrderIdExist(orderItemsRequest.getOrderId())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ErrorResponse("error", "Enter a valid orderId"));
                }
                orderItems = orderItemsService.getByOrderId(orderItemsRequest.getOrderId());
            } else if (orderItemsRequest.getName() != null) {
                if (!orderItemsService.doesNameExist(orderItemsRequest.getName())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ErrorResponse("error", "Enter a valid item name"));
                }
                orderItems = orderItemsService.getByItemName(orderItemsRequest.getName());
            } else {
                orderItems = orderItemsService.getAllOrderItems();
            }

            if (orderItems.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("error", "No Records found."));
            } else {
                return ResponseEntity.ok(orderItems);
            }
        } catch (Exception e) {
            // Handle other exceptions and return appropriate error response
            ErrorResponse responseMessage = new ErrorResponse("error", e.getMessage());
            return ResponseEntity.badRequest().body(responseMessage);
        }

    }


}







