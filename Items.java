package com.task.api.entity;

import com.task.api.dto.ItemsDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection="items")
public class Items {

    @Id
    private String id=UUID.randomUUID().toString();

    private String name;

    private int code;

    private String uom;

    private int availableCount = 0;

    private String viewedBy;

    private int alertCount = 0;

    private String module = "STATIONARY";

    private String status = "ACTIVE";

    private Date updatedOn=null;

    private Date createdOn = new Date();

    public Items() {
    }
//    public Items(String name,int code,String uom,int availableCount,String viewedBy,int alertCount){
//        this.name=name;
//        this.code=code;
//        this.uom=uom;
//        this.availableCount=availableCount;
//        this.viewedBy=viewedBy;
//        this.alertCount=alertCount;
//    }

//    public Items(ItemsDTO itemsDTO) {
//
//        this.name = itemsDTO.getName();
//        this.code = itemsDTO.getCode();
//        this.uom = itemsDTO.getUom();
//        this.availableCount = itemsDTO.getAvailableCount();
//        this.viewedBy = itemsDTO.getViewedBy();
//        this.alertCount = itemsDTO.getAlertCount();
//    }

    public Items(ItemsDTO itemsDTO) {
        this.name=name;
        this.code=code;
        this.uom=uom;
        this.availableCount=availableCount;
        this.viewedBy=viewedBy;
        this.alertCount=alertCount;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getViewedBy() {
        return viewedBy;
    }

    public void setViewedBy(String viewedBy) {
        this.viewedBy = viewedBy;
    }


    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }


}

