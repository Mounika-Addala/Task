package com.task.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;
import java.util.UUID;


@Document(collection = "orderitems")
public class OrderItems {
    @Id
    @Field(targetType = FieldType.STRING)
    private String _id = UUID.randomUUID().toString();

    @Field(targetType = FieldType.STRING)
    private String orderId = UUID.randomUUID().toString();

    private String poNumber;
    private String name;
    private int code;
    private String uom;
    private String itemId;
    private int consumedCount;
    private int receivedCount;
    private double totalAmount;
    private String receivedItems;
    private String status="ACTIVE";
    private Date updatedOn=null;
    private Date createdOn=new Date();
    private Boolean isConsumed;
    private String siteId;

    public OrderItems() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getConsumedCount() {
        return consumedCount;
    }

    public void setConsumedCount(int consumedCount) {
        this.consumedCount = consumedCount;
    }

    public int getReceivedCount() {
        return receivedCount;
    }

    public void setReceivedCount(int receivedCount) {
        this.receivedCount = receivedCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReceivedItems() {
        return receivedItems;
    }

    public void setReceivedItems(String receivedItems) {
        this.receivedItems = receivedItems;
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

    public Boolean getConsumed() {
        return isConsumed;
    }

    public void setConsumed(Boolean consumed) {
        isConsumed = consumed;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
}
