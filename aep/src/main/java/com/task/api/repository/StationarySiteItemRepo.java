package com.task.api.repository;

import com.task.api.entity.StationarySiteItems;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StationarySiteItemRepo extends MongoRepository<StationarySiteItems,String> {
}
