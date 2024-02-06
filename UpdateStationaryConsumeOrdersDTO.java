
package com.task.api.dto;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

public class UpdateStationaryConsumeOrdersDTO{
	 @Id
	  @NotBlank()
	 private String _id; 
	 private String siteId;
	 private String siteName;
	 private Date transactionDate;
	//    private String status="ACTIVE";
	    private Date updatedOn;
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
		public Date getUpdatedOn() {
			return updatedOn;
		}
		public void setUpdatedOn(Date updatedOn) {
			this.updatedOn = updatedOn;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
}