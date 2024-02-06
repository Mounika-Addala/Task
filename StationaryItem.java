package com.task.api.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import com.task.api.dto.OrderItemsDTONew;
import com.task.api.dto.StationaryItemRequest;
import com.task.api.dto.OrderItemsDTONew.Item;
import com.task.api.entity.OrderItems.ReceivedItems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "stationary_items")
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
    
    private String filePath = null;
    

    @NotNull(message = "Alert Count is required")
    private int alertCount;

    private String module = "STATIONARY";
    private String status = "ACTIVE";
    private Date updatedOn = null;
    private Date createdOn = new Date();


    public StationaryItem() {
    }

    public StationaryItem(String name, int code, String uom, String viewedBy, int alertCount, Date date) {
        this.name = name;
        this.code = code;
        this.uom = uom;
        this.viewedBy = viewedBy;
        this.alertCount = alertCount;
        this.updatedOn=date;
    }
    
    
    public StationaryItem(StationaryItemRequest itemRequest,String filepath) {
        // Constructor for StationaryItemRequest
        this.name = itemRequest.getName().toLowerCase().trim();
        this.code = itemRequest.getCode();
        this.uom = itemRequest.getUom();
        this.viewedBy = itemRequest.getViewedBy();
        this.alertCount = itemRequest.getAlertCount();
        this.updatedOn = null; 
        this.filePath = filepath;
        this.createdOn = new Date();
    }
  

    public StationaryItem(StationaryItemRequest itemRequest) {
        // Constructor for StationaryItemRequest
        this.name = itemRequest.getName().toLowerCase().trim();
        this.code = itemRequest.getCode();
        this.uom = itemRequest.getUom();
        this.viewedBy = itemRequest.getViewedBy();
        this.alertCount = itemRequest.getAlertCount();
        this.updatedOn = null; 
        this.createdOn = new Date();
    }
    
    public StationaryItem(String name, int code, String uom, String viewedBy, int alertCount) {
        this.name = name;
        this.code = code;
        this.uom = uom;
        this.viewedBy = viewedBy;
        this.alertCount = alertCount;
        // Set other fields as needed
    }

	public StationaryItem(Object setName) {
		// TODO Auto-generated constructor stub
	}

	

	public <filePath1> StationaryItem(String name2, int code2, String uom2, String viewedBy2, int alertCount2,
			Date date, filePath1 filePath2) {
		 this.name = name2.toLowerCase().trim();
	        this.code = code2;
	        this.uom = uom2;
	        this.viewedBy = viewedBy2;
	        this.alertCount =alertCount2;
	        this.updatedOn = null; 
	        this.filePath = (String) filePath2;
	        this.createdOn = new Date();
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	

	
    public void updateAlertCount(int alertCount) {
	  //  if (items != null && !items.isEmpty()) {
	       
    	 this.alertCount =alertCount;

	     //   }
	  
    
    //}
	}

	
}
