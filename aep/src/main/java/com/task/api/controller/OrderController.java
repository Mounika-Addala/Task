package com.task.api.controller;

import com.task.api.dto.OrderRequest;
import com.task.api.entity.Orders;
import com.task.api.entity.Site;
import com.task.api.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> addNewOrder(@RequestBody OrderRequest orderRequest)
    {

            Orders newOrder = orderService.newOrder(orderRequest);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);



   }
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

    @GetMapping("/getOrderDetails")
    public ResponseEntity<List<Orders>> getAllOrders(){
        List<Orders> orders=orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
//    @GetMapping("/site")
//    public ResponseEntity<List<Site>> getAllActiveSites() {
//        List<Site> sites = apiService.getAllActiveSites();
//        return new ResponseEntity<>(sites, HttpStatus.OK);
//    }

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