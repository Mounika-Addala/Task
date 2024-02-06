package com.task.api.controller;

import com.task.api.dto.ItemsDTO;
import com.task.api.entity.Items;
import com.task.api.service.ItemsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import responseEntity.ErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemsController {

    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }


    @PostMapping("/additem")
    public ResponseEntity<?> addItem(@Valid @RequestBody ItemsDTO itemDTO, BindingResult result) {

        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            ErrorResponse responseMessage= (ErrorResponse) new responseEntity.ErrorResponse("error",msg);
            return  ResponseEntity.badRequest().body(responseMessage);
        }

//        if (result.hasErrors()) {
//            JsonObject errors = new JsonObject();
//            for (FieldError error : result.getFieldErrors()) {
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
//        }
        Items newItem = itemsService.newItem(itemDTO);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemsService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    //    @GetMapping("/getItem")
//    public List<Items> getAllItems() {
//        return itemsService.getAllItems();
//    }

//    @GetMapping("/getItem")
//    public ResponseEntity<Items> getItem(@RequestParam ItemsDTO itemsDTO) {
//        Items item = itemsService.newItem(itemsDTO);
//        return new ResponseEntity<>(item, HttpStatus.OK);
//    }

}
