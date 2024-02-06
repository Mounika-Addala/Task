package com.task.api.repository;
import java.io.InputStream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.task.api.entity.StationaryItem;


@Repository
public interface StationaryItemRepository extends MongoRepository<StationaryItem, String> {
    // You can add custom query methods here if needed
}
