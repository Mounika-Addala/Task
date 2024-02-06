package com.task.api.entity;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Document(collection = "orders")
public class Orders {
   @Id
    private String _id = UUID.randomUUID().toString();
    @NotNull(message = "PONumber is required")
    private  String poNumber;
    private String invoiceDate;
    @NotNull(message = "SiteName is required")
    private String siteName;
    @NotNull(message = "SiteId is required")
    private String siteId;
    private String invoicePath;
    private int itemsCount;
    private double totalAmount;
    private String status = "ACTIVE";
    private String updatedOn = null;
    private String createdOn = null;
    private int actualCount;
    @NotNull(message = "Vendor Name is required")
    private String vendorName;
    private String invoiceFile = null;
    private String file = null;
    public String getFile() {
		return file;
	}

	

	private String invoiceNumber;

	  public Orders() {
	    }

//	    public Orders(String poNumber, String siteName, String siteId, Date invoiceDate, String file) {
//	        this.poNumber = poNumber;
//	        this.siteName = siteName;
//	        this.siteId = siteId;
//	        this.invoiceDate = invoiceDate;
//	        this.file = file;
//	        // Initialize other fields as needed...
//	    }

    
//    public Orders(String _id, String poNumber, Date invoiceDate, String siteName, String siteId, String invoicePath, int itemsCount, double totalAmount, String status, Date updatedOn, Date createdOn, int actualCount, String vendorName, String invoiceFile, String invoiceNumber) {
//        this._id = _id;
//        this.poNumber = poNumber;
//        this.invoiceDate = invoiceDate;
//        this.siteName = siteName;
//        this.siteId = siteId;
//        this.invoicePath = invoicePath;
//        this.itemsCount = itemsCount;
//        this.totalAmount = totalAmount;
//        this.status = status;
//        this.updatedOn = updatedOn;
//        this.createdOn = createdOn;
//        this.actualCount = actualCount;
//        this.vendorName = vendorName;
//        this.invoiceFile = invoiceFile;
//        this.invoiceNumber = invoiceNumber;
//    }

  

	    public <filePath1> Orders(String invoiceNumber2, String vendorName2, String siteName2, String siteId2,
			String poNumber2, Date invoiceDate2, filePath1 filePath) {
	    	 this.invoiceNumber = invoiceNumber2;
	         this.poNumber = poNumber2;
	         this.vendorName=vendorName2;
	         this.siteName = siteName2;
	         this.siteId = siteId2;
	         this.invoiceDate = null;
	         this.file = (String) filePath;
	        
	}

	


	public <filePath1> Orders(String invoiceNumber2, String vendorName2, String siteName2, String siteId2,
			String poNumber2, String invoiceDate2, filePath1 filePath) {
		this.invoiceNumber = invoiceNumber2;
        this.poNumber = poNumber2;
        this.vendorName=vendorName2;
        this.siteName = siteName2;
        this.siteId = siteId2;
       // try {
      // 	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			this.invoiceDate = invoiceDate2;
		//} catch (ParseException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
        this.file = (String) filePath;
        

        this.invoicePath = (String) filePath;
//        this.itemsCount = 0;
//        this.totalAmount = 0;
//        this.status = "ACTIVE";
//        this.updatedOn = null;
//        this.createdOn = new Date();
//        this.actualCount = 0;
//        this.vendorName = vendorName2;
//        this.invoiceFile = (String) filePath;
//        this.invoiceNumber = invoiceNumber2;
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



    public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public void setFile(String file) {
		this.file = file;
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
