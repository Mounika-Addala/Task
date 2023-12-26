package com.task.api.service;

import com.task.api.dto.StationaryItemRequest;
import com.task.api.entity.Site;
import com.task.api.entity.StationaryItem;
import com.task.api.entity.StationarySiteItems;
import com.task.api.repository.SiteRepo;
import com.task.api.repository.StationaryItemRepo;
import com.task.api.repository.StationarySiteItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@Service
public class ApiService {
    private final SiteRepo siteRepo;
    private final StationaryItemRepo stationaryItemRepo;
    private final StationarySiteItemRepo stationarySiteItemRepo;
    
    

    public ApiService(SiteRepo siteRepo, StationaryItemRepo stationaryItemRepo, StationarySiteItemRepo stationarySiteItemRepo) {
        this.siteRepo = siteRepo;
        this.stationaryItemRepo = stationaryItemRepo;
        this.stationarySiteItemRepo = stationarySiteItemRepo;
    }

    public List<Site> getAllActiveSites() {
        return siteRepo.findAllByStatus("ACTIVE");
    }
    public List<StationaryItem> getAllStationary(){
        return (List<StationaryItem>) stationaryItemRepo.findAll();
    }
    
    private MongoTemplate mongoTemplate;
    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public StationaryItem addNewItem(StationaryItemRequest itemRequest) {


//    	 if (stationaryItemRepo.existsByName(itemRequest.getName().toLowerCase().trim())) {
//    	        throw new DuplicateItemException("Item with name '" + itemRequest.getName() + "' already exists.");
//    	    }
    	 if (stationaryItemRepo.existsByName(itemRequest.getName().toLowerCase().trim())) {
    	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
    	                "Item with name '" + itemRequest.getName() + "' already exists.");
    	    }


        StationaryItem newItem = new StationaryItem(itemRequest);
        newItem.setName(itemRequest.getName().toLowerCase().trim());
        newItem.setCode(itemRequest.getCode());
        newItem.setUom(itemRequest.getUom());
        newItem.setViewedBy(itemRequest.getViewedBy());
        newItem.setAlertCount(itemRequest.getAlertCount());


        newItem.setCreatedOn(new Date());
        StationaryItem savedItem = stationaryItemRepo.save(newItem);


        List<Site> activeSites = getAllActiveSites();
        //System.out.println("Active Sites: " + activeSites);
        for (Site site : activeSites) {
            StationarySiteItems siteItem = new StationarySiteItems();

            siteItem.setItemId(savedItem.get_id());
            siteItem.setItemName(savedItem.getName());

            siteItem.setSiteId(site.get_id());
            siteItem.setSiteName(site.getSiteName());
            siteItem.setUpdatedOn(null);
            siteItem.setCreatedOn(new Date());

            stationarySiteItemRepo.save(siteItem);
        }
        // System.out.println("done");
        //return ok(savedItem);
        return savedItem;
    }
        
    
}



//if (itemRequest == null &&
//                itemRequest.getName() == null && itemRequest.getName().trim().isEmpty() &&
//                itemRequest.getCode() == 0 && itemRequest.getUom() == null &&
//                itemRequest.getViewedBy() == null && itemRequest.getAlertCount() == 0) {
//            System.out.println("Please enter valid details");
//            return ResponseEntity.badRequest().body("Please enter valid details");
//        }
//
//       String itemName = itemRequest.getName().toLowerCase().trim();
//
//     //   String itemName = (itemRequest.getName() != null) ? itemRequest.getName().toLowerCase().trim() : null;
//
//        if (stationaryItemRepo.existsByName(itemName)) {
//            System.out.println("Item with the same name already exists. Please choose a different name.");
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Item with the same name already exists. Please choose a different name.");
//        }



























