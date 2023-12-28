package com.task.api.repository;

import com.task.api.entity.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepo extends MongoRepository<Orders,String> {
    void save(String orders);
}
