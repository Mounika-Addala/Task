package com.task.api.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.task.api.dto.StationaryConsumeOrdersDTO;

import java.util.Date;
import java.util.UUID;

@Document(collection = "stationaryconsumeorders")
public class StationaryConsumeOrders {

    private String _id= UUID.randomUUID().toString();
    
    private String siteId;
    
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    
    private String siteName;
    private Date transactionDate;
    private String status="ACTIVE";
    private Date createdOn;
    private Date updatedOn=null;
    private String remarks;
    
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public StationaryConsumeOrders() {
    	
    }

    public StationaryConsumeOrders(StationaryConsumeOrdersDTO dto) {
		this.siteId=dto.getSiteId();
		this.siteName=dto.getSiteName();
		this.transactionDate=dto.getTransactionDate();
		this.remarks=dto.getRemarks();
		//this.updatedOn=dto.getUpdatedOn();
	}

	public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

	public String getRemarks() {
		return remarks;
	}
	 
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	

//	public void setRemarks(String remarks) {
//		// TODO Auto-generated method stub
//		
//	}

	 
	
}





