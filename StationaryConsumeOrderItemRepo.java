package com.task.api.repository;

import com.task.api.entity.StationaryConsumeOrderItems;
import com.task.api.entity.StationarySiteItems;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationaryConsumeOrderItemRepo extends MongoRepository<StationaryConsumeOrderItems,String> {

	List<StationaryConsumeOrderItems> findByOrderIdAndItemId(String orderId, String itemId);
	//<StationaryConsumeOrders> Optional<StationaryConsumeOrders> findByOrderIdAndSiteId(String orderId, String siteId);
}

//public interface StationaryConsumeOrderItemRepo extends MongoRepository<StationaryConsumeOrderItems, String> {
//    Optional<StationaryConsumeOrderItems> findByOrderIdAndSiteId(String orderId, String siteId);
//}
