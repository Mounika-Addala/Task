package com.task.api.dto;

import jakarta.validation.constraints.NotNull;

public class OrderItemsRequest {

  //  @NotNull(message = "OrderId cannot be null")
    private String orderId;

   // @NotNull(message = "ItemName cannot be null")
    private String name;

   // @NotNull(message = "ItemId cannot be null")
    private String itemId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
