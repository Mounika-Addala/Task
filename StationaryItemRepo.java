package com.task.api.repository;

import com.task.api.entity.StationaryItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationaryItemRepo extends MongoRepository<StationaryItem,String> {
    boolean existsByName(String itemName);

    StationaryItem findBy_id(String itemId);

    StationaryItem findByName(String trim);

	//StationaryItem findAll(String itemId);
}
