package com.task.api.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.api.entity.StationarySiteItems;

public interface StationarySiteItemRepoAnother extends MongoRepository<StationarySiteItems,String> {

    List<StationarySiteItems> findByItemIdAndSiteId(String itemId,String siteId);

	StationarySiteItems save(List<StationarySiteItems> existingSiteItems);

 
}