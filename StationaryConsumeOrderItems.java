package com.task.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.task.api.dto.StationaryConsumeOrderItemsDTO;
import com.task.api.dto.StationaryConsumeOrderItemsDTO.Item;


import java.util.Date;
import java.util.UUID;




@Document(collection = "stationaryconsumeorderitems")
public class StationaryConsumeOrderItems {

    @Id
    private String _id = UUID.randomUUID().toString();
    private String orderId;
    private String itemId;
    private String itemName;
    private String uom;
    private Integer quantity;
    private Integer unitPrice;
    private Integer consume;
    private Double totalPrice;
    private String status = "ACTIVE";
    private Date createdOn;
    private Date updatedOn;
    private String ref;
    private String issuedBy;
    private String requestedBy;

    public StationaryConsumeOrderItems() {
        // Default constructor
    }

    // Constructor for creating an instance using values directly
    public StationaryConsumeOrderItems(String orderId, String itemId, String itemName, String uom,
                                       Integer quantity, Integer unitPrice, Integer consume,
                                       Double totalPrice, String status, Date createdOn,
                                       Date updatedOn, String ref, String issuedBy,
                                       String requestedBy) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.uom = uom;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.consume = consume;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.ref = ref;
        this.issuedBy = issuedBy;
        this.requestedBy = requestedBy;
    }

    // Constructor for creating an instance from DTOs
    public StationaryConsumeOrderItems(StationaryConsumeOrderItemsDTO mainDTO, Item itemDTO) {
        this.orderId = mainDTO.getOrderId();
        this.itemId = itemDTO.getItemId();
        this.itemName = itemDTO.getItemName();
        this.uom = itemDTO.getUom();
       this.quantity = itemDTO.getConsumeCount();
        this.unitPrice = itemDTO.getUnitPrice();
       this.consume = itemDTO.getConsumeCount();
        this.totalPrice = (double) (itemDTO.getUnitPrice() * itemDTO.getConsumeCount());
        this.status = "ACTIVE";
        this.createdOn = new Date();
        this.ref = itemDTO.getRef();
        this.issuedBy = mainDTO.getIssuedBy();
        this.requestedBy = itemDTO.getRequestedBy();
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

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }
}