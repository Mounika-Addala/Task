package com.task.api.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.api.dto.StationaryItemRequest;

import java.util.Date;
import java.util.UUID;

@Document(collection = "stationary_items")
@JsonIgnoreProperties({"_class"})

public class StationaryItem {
    @Id
    @Field(targetType = FieldType.STRING)
    private String _id = UUID.randomUUID().toString();


    @NotBlank(message = "Name is required")
    @Indexed(unique = true)
    private String name;

    @NotNull(message = "Code is required")
    private int code;

    @NotBlank(message = "UOM is required")
    private String uom;

    @NotBlank(message = "Viewed By is required")
    private String viewedBy;

    @NotNull(message = "Alert Count is required")
    private int alertCount;

    private String module = "STATIONARY";
    private String status = "ACTIVE";
    private Date updatedOn = null;
    private Date createdOn = new Date();

    public StationaryItem(String name, int code, String uom, String viewedBy, int alertCount,Date date) {
        this.name = name;
        this.code = code;
        this.uom = uom;
        this.viewedBy = viewedBy;
        this.alertCount = alertCount;
        this.updatedOn=date;
    }


	public StationaryItem(StationaryItemRequest itemRequest) {
		
		this.name = itemRequest.getName();
	    this.code = itemRequest.getCode();
	    this.uom = itemRequest.getUom();
	    this.viewedBy = itemRequest.getViewedBy();
	    this.alertCount = itemRequest.getAlertCount();
	    
	}



	public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getViewedBy() {
        return viewedBy;
    }

    public void setViewedBy(String viewedBy) {
        this.viewedBy = viewedBy;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
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
}
