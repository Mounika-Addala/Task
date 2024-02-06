package com.task.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemsDTO {
    @NotBlank(message = "Order id is required")
    private String orderId;

    @NotBlank(message = "poNumber is required")
    private String poNumber;
    @NotNull(message = "code is required")
    private Integer code;
    @NotEmpty(message="uom should not be empty")
    private String uom;
    @NotBlank(message="Name is required")
    private String name;
    @NotBlank(message = "SiteId is required")
    private String siteId;
    @NotBlank(message = "itemId is required")
    private String itemId;
    private int receivedCount;
    private double totalAmount;

    @Valid
    @NotEmpty(message = "Received items list must not be empty")
    private List<ReceivedItemsDTO> receivedItems;

    private boolean isConsumed;

//    public List<ReceivedItemsDTO> getReceivedItems() {
//        return null;
//    }



    // @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ReceivedItemsDTO {

       // @JsonProperty("itemName")
        @NotBlank(message = "Item name is required")
        private String itemName;
        @NotNull(message = "Unit price is required")
        @DecimalMin(value = "0.0", message = "Unit price must be greater than or equal to 0.0")
        private double unitPrice;
        @NotNull(message = "Count is required")
        @Positive(message = "Count must be greater than 0")
        private int count;
        @NotBlank(message = "dcNumber is required")
        private String dcNumber;
        @NotBlank(message = "itemCode is required")
        private String itemCode;
        @NotBlank(message="uom is required")
        private String uom;
        @NotNull(message = "consumedCount is required")
        private int consumedCount;
        private String ref;
        private boolean isConsumed;

        public ReceivedItemsDTO() {
        }

       public String getUom() {
           return uom;
       }

       public void setUom(String uom) {
           this.uom = uom;
       }

       public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDcNumber() {
           return dcNumber;
       }

       public void setDcNumber(String dcNumber) {
           this.dcNumber = dcNumber;
       }

       public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public int getConsumedCount() {
            return consumedCount;
        }

        public void setConsumedCount(int consumedCount) {
            this.consumedCount = consumedCount;
        }



        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public boolean isConsumed() {
            return isConsumed;
        }

        public void setConsumed(boolean consumed) {
            isConsumed = consumed;
        }
//        public boolean isConsumed() {
//            return isConsumed;
//        }
//
//        public void setConsumed(boolean consumed) {
//            isConsumed = consumed;
//        }
    }

//    public List<OrderItems.ReceivedItems> getReceivedItems() {
//        return receivedItems;
//    }
//
//    public void setReceivedItems(List<ReceivedItemsDTO> receivedItems) {
//        this.receivedItems = receivedItems;
//    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReceivedCount() {
        return receivedCount;
    }

    public void setReceivedCount(int receivedCount) {
        this.receivedCount = receivedCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public boolean getConsumed() {
        return isConsumed;
    }

    public void setConsumed(boolean consumed) {
        isConsumed = consumed;
    }

    public List<ReceivedItemsDTO> getReceivedItems() {
        return receivedItems;
    }

    public void setReceivedItems(List<ReceivedItemsDTO> receivedItems) {
        this.receivedItems = receivedItems;
    }
}
