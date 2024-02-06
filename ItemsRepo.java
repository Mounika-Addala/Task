package com.task.api.repository;

import com.task.api.dto.ItemsDTO;
import com.task.api.entity.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemsRepo extends MongoRepository<Items,String> {
    Items findByid(String id);

    // List<Items> findByItemsDTO(ItemsDTO itemsDTO);
//    List<Items> findByName(String name);
//    List<Items> findAll();


}
