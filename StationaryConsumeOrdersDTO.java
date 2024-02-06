package com.task.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StationaryConsumeOrdersDTO {

	@NotNull(message="Transaction Date is mandatory")
    private Date transactionDate;
	@NotBlank(message="SiteId is required")
    private String siteId;
	@NotBlank(message="siteName is required")
    private String siteName;
	@NotBlank(message="Remarks is mandatory")
    private String remarks;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}


