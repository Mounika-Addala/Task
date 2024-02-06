package com.task.api.repository;

import com.task.api.entity.OrderItems;
import com.task.api.entity.StationaryConsumeOrderItems;
//import com.task.api.entity.StationaryConsumeOrderItems;
import com.task.api.entity.StationaryConsumeOrders;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationaryConsumeOrdersRepo extends MongoRepository<StationaryConsumeOrders,String> {
	
	// List<StationaryConsumeOrders> findBy_id(String id);

	List<StationaryConsumeOrders> findBy_id(String orderId);

    StationaryConsumeOrders findBySiteId(StationaryConsumeOrders siteId);

    Optional<StationaryConsumeOrders> findByOrderIdAndSiteId(String orderId, String siteId);

	//void save(StationaryConsumeOrderItems stationaryConsumeOrderItems);

//	void save(StationaryConsumeOrderItems stationaryConsumeOrderItems);
}
