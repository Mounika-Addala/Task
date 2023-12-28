package com.task.api.entity;

import com.task.api.dto.OrderRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "orders")
public class Orders {
   @Id
    private String _id = UUID.randomUUID().toString();
    @NotNull(message = "PONumber is required")
    private  String poNumber;
    private Date invoiceDate;
    @NotNull(message = "SiteName is required")
    private String siteName;
    @NotNull(message = "SiteId is required")
    private String siteId;
    private String invoicePath;
    private int itemsCount;
    private double totalAmount;
    private String status="ACTIVE";
    private Date updatedOn=null;
    private Date createdOn=new Date();
    private int actualCount;
    @NotNull(message = "Vendor Name is required")
    private String vendorName;
    private String invoiceFile;
    private String invoiceNumber;

    public Orders() {
    }

    public Orders(String _id, String poNumber, Date invoiceDate, String siteName, String siteId, String invoicePath, int itemsCount, double totalAmount, String status, Date updatedOn, Date createdOn, int actualCount, String vendorName, String invoiceFile, String invoiceNumber) {
        this._id = _id;
        this.poNumber = poNumber;
        this.invoiceDate = invoiceDate;
        this.siteName = siteName;
        this.siteId = siteId;
        this.invoicePath = invoicePath;
        this.itemsCount = itemsCount;
        this.totalAmount = totalAmount;
        this.status = status;
        this.updatedOn = updatedOn;
        this.createdOn = createdOn;
        this.actualCount = actualCount;
        this.vendorName = vendorName;
        this.invoiceFile = invoiceFile;
        this.invoiceNumber = invoiceNumber;
    }

    public Orders(OrderRequest orderRequest) {
    }

    public Orders(String stringValue, String stringValue1, String stringValue2, String stringValue3, String stringValue4, Date date, String stringValue5) {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
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

    public String getInvoicePath() {
        return invoicePath;
    }

    public void setInvoicePath(String invoicePath) {
        this.invoicePath = invoicePath;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getActualCount() {
        return actualCount;
    }

    public void setActualCount(int actualCount) {
        this.actualCount = actualCount;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getInvoiceFile() {
        return invoiceFile;
    }

    public void setInvoiceFile(String invoiceFile) {
        this.invoiceFile = invoiceFile;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
