package com.task.api.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.api.entity.Orders;


public interface OrderRepo extends MongoRepository<Orders,String> {
  //  Orders findByOrderId(String orderId);

    Orders findBy_id(String orderId);
    // boolean existsByName(String itemName);

//	Orders save(Orders newItem);
}
