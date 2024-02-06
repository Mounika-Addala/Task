package com.task.api.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

public class UpdateOrderItemsDTO {
    @Id
    @NotBlank()
    private String _id;

    private String orderId;
    private String poNumber;
    private String name;
    private Integer code;  
    private String uom;
    private String siteId;
    private String itemId;
    private Integer consumedCount;
    private Integer receivedCount;
    private Double totalAmount;
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
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getConsumedCount() {
		return consumedCount;
	}
	public void setConsumedCount(Integer consumedCount) {
		this.consumedCount = consumedCount;
	}
	public Integer getReceivedCount() {
		return receivedCount;
	}
	public void setReceivedCount(Integer receivedCount) {
		this.receivedCount = receivedCount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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
	public Boolean getIsConsumed() {
		return isConsumed;
	}
	public void setIsConsumed(Boolean isConsumed) {
		this.isConsumed = isConsumed;
	}
	private String status = "ACTIVE";
    private Date updatedOn;
   // private Date createdOn = new Date();
    private Boolean isConsumed;
}