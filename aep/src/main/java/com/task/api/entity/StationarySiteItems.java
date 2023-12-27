package com.task.api.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.UUID;

@Document(collection="stationary_site_items")
//@TypeAlias("")
@JsonIgnoreProperties({"_class"})
public class StationarySiteItems {

    @Id
//    private UUID _id;
    @Field(targetType = FieldType.STRING)
    private String _id = UUID.randomUUID().toString();

    @Field(targetType = FieldType.STRING)
    private String itemId = UUID.randomUUID().toString();

    private String itemName;
    private String siteId;
    private String siteName;
    private int alertCount;
    private int availableCount = 0;
    private double itemPrice = 0.0;
    private String status="ACTIVE";
    private Date updatedOn;
    private Date createdOn;

    public StationarySiteItems() {
    }

    public StationarySiteItems(String itemId, String itemName, String siteId, String siteName, int alertCount,Date createdOn) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.siteId = siteId;
        this.siteName = siteName;
        this.alertCount = alertCount;
        this.createdOn=createdOn;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
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
}
