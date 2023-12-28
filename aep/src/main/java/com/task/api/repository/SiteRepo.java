package com.task.api.repository;

import com.task.api.entity.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SiteRepo extends MongoRepository<Site,String> {
//    List<Site> findAllByStatus(String active);

    List<Site> findAllByStatus(String status);
}

