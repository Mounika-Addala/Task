package com.task.api.repository;

import com.task.api.entity.StationaryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StationaryItemRepo extends MongoRepository<StationaryItem,String> {
    boolean existsByName(String itemName);
}



//public interface StationaryItemRepository extends MongoRepository<StationaryItem, String> {
//    // You can add custom query methods here if needed
//}