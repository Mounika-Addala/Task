package com.task.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.api.entity.OrderItems;

import java.util.List;
import java.util.Optional;


public interface OrderItemsRepo extends MongoRepository<OrderItems,String> {
    OrderItems findByItemIdAndOrderId(String itemId, String orderId);

    List<OrderItems> findByOrderIdAndItemId(String orderId, String itemId);

    List<OrderItems> findByOrderId(String orderId);
    List<OrderItems> findBy_id(String id);
    //Optional<OrderItems> findById(String id);

    List<OrderItems> findByname(String name);

    Optional<OrderItems> findByItemId(String itemId);
}
