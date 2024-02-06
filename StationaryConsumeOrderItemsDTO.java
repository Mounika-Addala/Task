package com.task.api.dto;


import java.util.List;

public class StationaryConsumeOrderItemsDTO {

    private String orderId;
    private String orderName;
    private String siteId;
    private String siteName;
    private String issuedBy;
    private List<Item> items;

    public static class Item {
        private String itemId;
        private Integer availableCount;  // Change type to Integer
        private String itemName;
        private int code;
        private String uom;
        private Integer consumeCount;    // Change type to Integer
        private int unitPrice;
        private String ref;
        private String requestedBy;

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public Integer getAvailableCount() {
            return availableCount;
        }

        public void setAvailableCount(Integer availableCount) {
            this.availableCount = availableCount;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
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

        public Integer getConsumeCount() {
            return consumeCount;
        }

        public void setConsumeCount(Integer consumeCount) {
            this.consumeCount = consumeCount;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getRequestedBy() {
            return requestedBy;
        }

        public void setRequestedBy(String requestedBy) {
            this.requestedBy = requestedBy;
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}




}
