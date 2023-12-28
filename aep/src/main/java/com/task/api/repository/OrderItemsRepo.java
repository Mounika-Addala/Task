package com.task.api.repository;

import com.task.api.entity.OrderItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemsRepo extends MongoRepository<OrderItems,String> {
}
