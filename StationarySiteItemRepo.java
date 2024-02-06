package com.task.api.repository;

import com.task.api.entity.StationarySiteItems;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface StationarySiteItemRepo extends MongoRepository<StationarySiteItems,String> {
    StationarySiteItems findByItemId(String itemId);
    //findByItemIdAndSiteId
    StationarySiteItems findByItemIdAndSiteId(String itemId,String siteId);

    StationarySiteItems findBySiteId(String siteId);

	//StationarySiteItems save(List<StationarySiteItems> updateAvalibleCount);
    StationarySiteItems save(List<StationarySiteItems> existingSiteItems);
    
}
