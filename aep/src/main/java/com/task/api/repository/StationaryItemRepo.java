package com.task.api.repository;

import com.task.api.entity.StationaryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationaryItemRepo extends MongoRepository<StationaryItem,String> {
    boolean existsByName(String itemName);

    Optional<StationaryItem> findById(String _id);

}




