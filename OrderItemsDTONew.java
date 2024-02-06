package com.task.api.dto;

import java.util.List;

import com.task.api.dto.OrderItemsDTO.ReceivedItemsDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderItemsDTONew {

    @NotBlank(message = "orderId is required")
    private String orderId;

//	@Valid
//  @NotEmpty(message = "Received items list must not be empty")
    private List<Item> item;
    
    public static class Item {

        // @JsonProperty("itemName")
         @NotBlank(message = "Item name is required")
         private String itemName;
         @NotNull(message = "Unit price is required")
         @DecimalMin(value = "0.0", message = "Unit price must be greater than or equal to 0.0")
         private double unitPrice;
         @NotNull(message = "dcNum is required")
         private String dcNum;
         @NotNull(message = "code is required")
         private int code;
//         @NotNull(message = "itemAvailCount is required")
//         private int itemAvailCount;
//         @NotNull(message = "isToggled is required")
//         private boolean isToggled;
		@NotNull(message = "Quantity is required")
         @Positive(message = "Quantity must be greater than 0")
         private int quantity ;
         @NotBlank(message = "itemId is required")
         private String itemId;
//         @NotBlank(message = "itemCode is required")
//         private int itemCode;
         @NotBlank(message="uom is required")
         private String uom;

         @NotNull(message = "consumedCount is required")
         private int consumedCount;

		 private String ref;

		public String getRef() {
			return ref;
		}

		public void setRef(String ref) {
			this.ref = ref;
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

		public String getItemId() {
			return itemId;
		}
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
//		public String getItemCode() {
//			return itemCode;
//		}
//		public void setItemCode(String itemCode) {
//			this.itemCode = itemCode;
//		}
		public String getUom() {
			return uom;
		}
		public void setUom(String uom) {
			this.uom = uom;
		}
		public int getConsumedCount() {
			return consumedCount;
		}
		public void setConsumedCount(int consumedCount) {
			this.consumedCount = consumedCount;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
//		public int getItemCode() {
//			return itemCode;
//		}
//
//		public void setItemCode(int itemCode) {
//			this.itemCode = itemCode;
//		}

		public String getDcNum() {
			return dcNum;
		}

		public void setDcNum(String dcNum) {
			this.dcNum = dcNum;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public @Valid @NotEmpty(message = "Received items list must not be empty")
	List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}



}

