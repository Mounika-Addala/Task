package com.task.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class OrderRequest {

    private String invoiceNumber;
    @NotBlank(message = "PONumber is required")
    private String poNumber;
    @NotBlank(message = "Vendor Name is required")
    private String vendorName;
    @NotBlank(message = "SiteName is required")
    private String siteName;
    @NotBlank(message = "SiteId is required")
    private String siteId;
    @NotBlank(message = "InvoiceDate is required")
    private Date invoiceDate;
    private String invoiceFile;



    public OrderRequest(String invoiceNumber, String poNumber,String vendorName, String siteName, String siteId, Date invoiceDate, String  invoiceFile) {
        this.invoiceNumber = invoiceNumber;
        this.poNumber = poNumber;
        this.vendorName=vendorName;
        this.siteName = siteName;
        this.siteId = siteId;
        this.invoiceDate = invoiceDate;
        this.invoiceFile =  invoiceFile ;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceFile() {
        return invoiceFile;
    }

    public void setInvoiceFile(String invoiceFile) {
        this.invoiceFile = invoiceFile;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}



