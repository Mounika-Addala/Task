package com.task.api.entity;

import com.task.api.dto.OrderItemsDTO;
import com.task.api.dto.OrderItemsDTONew;
import com.task.api.dto.OrderItemsDTONew.Item;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Document(collection = "orderitems")
public class OrderItems {
    @Id
    @Field(targetType = FieldType.STRING)
    private String _id = UUID.randomUUID().toString();

    private String orderId;

    private String poNumber;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Code is required")
    private int code;
    @NotBlank(message = "UOM is required")
    private String uom;
    @NotBlank(message = "SiteId is required")
    private String siteId;

    @NotBlank(message = "itemId is required")
    private String itemId;
    private int consumedCount;
    private int receivedCount;
    private double totalAmount;
   // private String receivedItems;
    private String status="ACTIVE";
    private Date updatedOn=null;
    private Date createdOn=new Date();
    private boolean isConsumed;

    private List<ReceivedItems> receivedItems;


    public static OrderItems fromDTO(OrderItemsDTO orderItemsDTO){
        OrderItems orderItems=new OrderItems();
        orderItems.setOrderId(orderItemsDTO.getOrderId());
        orderItems.setPoNumber(orderItemsDTO.getPoNumber());
        orderItems.setName(orderItemsDTO.getName());
        orderItems.setCode(orderItemsDTO.getCode());
        orderItems.setUom(orderItemsDTO.getUom());
        orderItems.setSiteId(orderItemsDTO.getSiteId());
        orderItems.setItemId(orderItemsDTO.getItemId());
        //orderItems.setConsumedCount(orderItemsDTO.getConsumedCount());
        orderItems.setReceivedCount(orderItemsDTO.getReceivedCount());
        orderItems.setTotalAmount(orderItemsDTO.getTotalAmount());
        orderItems.setConsumed(orderItemsDTO.getConsumed());
       // orderItems.setStatus(OrderItemsDTO.getStatus);
        orderItems.setReceivedItems(mapReceivedItemsDTOToReceivedItems(orderItemsDTO.getReceivedItems()));
        return orderItems;


    }

    
    
    public static OrderItems saveDTO(OrderItemsDTONew orderItemsDTO) {
        OrderItems orderItems = new OrderItems();
        orderItems.setOrderId(orderItemsDTO.getOrderId());
        // orderItems.setStatus(OrderItemsDTO.getStatus);
        orderItems.setReceivedItems(mapReceivedItemsDTOToReceivedItems1(orderItemsDTO.getItem()));
        return orderItems;
    }

    private static List<ReceivedItems> mapReceivedItemsDTOToReceivedItems1(List<OrderItemsDTONew.Item> items) {
        return items.stream()
                .map(receivedItemsDTO -> {
                    ReceivedItems receivedItems1 = new ReceivedItems();
                    receivedItems1.setDcNum(receivedItemsDTO.getDcNum());
                    receivedItems1.setConsumedCount(receivedItemsDTO.getConsumedCount());
                    receivedItems1.setUnitPrice(receivedItemsDTO.getUnitPrice());
                    receivedItems1.setCount(receivedItemsDTO.getQuantity());
                   // receivedItems1.setItemCode(receivedItemsDTO.getItemCode());
                  //  receivedItems1.setUom(receivedItemsDTO.getUom());
                   // receivedItems1.setRef(receivedItemsDTO.isToggled() ? "Toggled" : "Not Toggled");
                    // Set other properties as needed
                    return receivedItems1;
                })
                .collect(Collectors.toList());
    }
    
    private static List<ReceivedItems> mapReceivedItemsDTOArray(List<OrderItemsDTONew.Item> items) {
        return items.stream()
                .map(receivedItemsDTO -> {
                    ReceivedItems receivedItems1 = new ReceivedItems();
                    receivedItems1.setDcNumber(receivedItemsDTO.getDcNum());
                    receivedItems1.setConsumedCount(receivedItemsDTO.getConsumedCount());
                    receivedItems1.setUnitPrice(receivedItemsDTO.getUnitPrice());
                    receivedItems1.setCount(receivedItemsDTO.getQuantity());
                   // receivedItems1.setItemCode(receivedItemsDTO.getItemCode());
                   // receivedItems1.setUom(receivedItemsDTO.getUom());
                   // receivedItems1.setRef(receivedItemsDTO.isToggled() ? "Toggled" : "Not Toggled");
                    // Set other properties as needed
                    return receivedItems1;
                })
                .collect(Collectors.toList());
    }



	private static List<ReceivedItems> mapReceivedItemsDTOToReceivedItems(List<OrderItemsDTO.ReceivedItemsDTO> receivedItemsDTOS){
        return (List<ReceivedItems>) receivedItemsDTOS.stream()
                .map(receivedItemsDTO ->
                {
                    ReceivedItems receivedItems1=new ReceivedItems();
                    receivedItems1.setDcNumber(receivedItemsDTO.getDcNumber());
                    receivedItems1.setConsumedCount(receivedItemsDTO.getConsumedCount());
                    receivedItems1.setUnitPrice(receivedItemsDTO.getUnitPrice());
                    receivedItems1.setCount(receivedItemsDTO.getCount());
                  //  receivedItems1.setItemCode(receivedItemsDTO.getItemCode());
                  //  receivedItems1.setUom(receivedItemsDTO.getUom());
                    receivedItems1.setRef(receivedItemsDTO.getRef());
                   // receivedItems1.set(receivedItemsDTO.getUom());
                    receivedItems1.setConsumed(receivedItemsDTO.isConsumed());
                    return receivedItems1;
                })
                .collect(Collectors.toList());
    }

	
	
	
	//public void updateReceivedItems(@Valid List<Item> items) {
		public void updateReceivedItemsList(List<OrderItemsDTONew.Item> items) {
	    if (items != null && !items.isEmpty()) {
	        if (receivedItems == null) {
	            receivedItems = new ArrayList<>();
	        }
	        for (Item newReceivedItem : items) {
	            ReceivedItems receivedItem = new ReceivedItems();
	            receivedItem.setDcNum(newReceivedItem.getDcNum());
	            receivedItem.setConsumedCount(newReceivedItem.getConsumedCount());
	            receivedItem.setUnitPrice(newReceivedItem.getUnitPrice());
	            receivedItem.setCount(newReceivedItem.getQuantity());
//	            receivedItem.setCode(newReceivedItem.getItemCode());
	            // receivedItem.setUom(newReceivedItem.getUom());
	            receivedItems.add(receivedItem);
	        }
	    }
	}

	
		
	
	
    public void updateReceivedItems(List<OrderItemsDTO.ReceivedItemsDTO> newReceivedItems){
        if(newReceivedItems != null && !newReceivedItems.isEmpty()){
            if(receivedItems==null){
                receivedItems=new ArrayList<>();
            }
            for(OrderItemsDTO.ReceivedItemsDTO newReceivedItem :newReceivedItems) {
                ReceivedItems receivedItem=new ReceivedItems();
                receivedItem.setDcNumber(newReceivedItem.getDcNumber());
                receivedItem.setConsumedCount(newReceivedItem.getConsumedCount());
                receivedItem.setUnitPrice(newReceivedItem.getUnitPrice());
                receivedItem.setCount(newReceivedItem.getCount());
              //  receivedItem.setItemCode(newReceivedItem.getItemCode());
              //  receivedItem.setUom(newReceivedItem.getUom());
                receivedItems.add(receivedItem);
            }
        }
    }

    
    
    
    public void updateReceivedItemsFromList(List<Item> list) {

        if(list != null && !list.isEmpty()){
            if(receivedItems==null){
                receivedItems=new ArrayList<>();
            }
            for(OrderItemsDTONew.Item newReceivedItem :list) {
                ReceivedItems receivedItem=new ReceivedItems();
                receivedItem.setDcNum(newReceivedItem.getDcNum());
                receivedItem.setConsumedCount(newReceivedItem.getConsumedCount());
                receivedItem.setUnitPrice(newReceivedItem.getUnitPrice());
                receivedItem.setCount(newReceivedItem.getQuantity());
              //  receivedItem.setItemCode(newReceivedItem.getItemCode());
              //  receivedItem.setUom(newReceivedItem.getUom());
                receivedItems.add(receivedItem);
            }
        }
    }



        public void addReceivedItem(List<OrderItemsDTO.ReceivedItemsDTO> receivedItem) {
        if (receivedItems == null) {
            receivedItems = new ArrayList<>();
        }
       // this.receivedItems.addAll(receivedItems);
            this.receivedItems.addAll(mapReceivedItemsDTOToReceivedItems(receivedItem));

        //receivedItems.add(receivedItem);
    }





    public void updateTotalAmount() {
    double totalAmount = 0.0;

    if (receivedItems != null) {
        for (ReceivedItems receivedItem : receivedItems) {
            totalAmount += receivedItem.getCount() * receivedItem.getUnitPrice();
        }
    }

    this.totalAmount = totalAmount;
}
    public void updateReceivedCount() {
        int receivedCount = 0;
        if (receivedItems != null) {
            for (ReceivedItems receivedItem : receivedItems) {
                receivedCount += receivedItem.getCount();
            }
        }

        this.receivedCount = receivedCount;
    }



    public static class ReceivedItems {
        private Date date=new Date();
        private String dcNumber;
        private int count;
        private int consumedCount;
        private double unitPrice;
        private String ref=UUID.randomUUID().toString();
        private boolean isConsumed;
       // private String status;
       // private Date updatedOn;
       // private Date createdOn;
        private String siteId;

       // private int quantity;
       // private String itemCode;
       // private String uom;
      //  private String itemId;
        private String itemName;


        public boolean isConsumed(){
            return count==consumedCount;
    }

        public void setDcNum(String dcnum) {
			// TODO Auto-generated method stub
			
		}

		public void setDcNum(int dcnum) {
			// TODO Auto-generated method stub
			
		}

		public ReceivedItems() {
        }

//        public int getQuantity() {
//            return quantity;
//        }
//
//        public void setQuantity(int quantity) {
//            this.quantity = quantity;
//        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getDcNumber() {
            return dcNumber;
        }

        public void setDcNumber(String dcNumber) {
            this.dcNumber = dcNumber;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getConsumedCount() {
            return consumedCount;
        }

        public void setConsumedCount(int consumedCount) {
            this.consumedCount = consumedCount;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

//        public boolean isConsumed() {
//            return isConsumed;
//        }

        public void setConsumed(boolean consumed) {
            isConsumed = consumed;
        }


        public String getSiteId() {
            return siteId;
        }

        public void setSiteId(String siteId) {
            this.siteId = siteId;
        }

        public void add(ReceivedItems receivedItems) {
        }
    }



//    public OrderItems(OrderItemsDTO orderItemsDTO) {
//        this.orderId=orderItemsDTO.getOrderId();
//        this.poNumber=orderItemsDTO.getPoNumber();
//        this.code=orderItemsDTO.getCode();
//        this.uom=orderItemsDTO.getUom();
//        this.name=orderItemsDTO.getName();
//        this.receivedCount=orderItemsDTO.getReceivedCount();
//        this.totalAmount=orderItemsDTO.getTotalAmount();
//        this.siteId=orderItemsDTO.getSiteId();
//        this.itemId=orderItemsDTO.getItemId();
//        this.receivedItems= (List<ReceivedItems>) orderItemsDTO.getReceivedItems();
//        this.isConsumed=orderItemsDTO.getConsumed();
//
//    }

//    public OrderItems(OrderItemsDTO orderItemsDTO) {
//        this.orderId=orderId;
//        this.poNumber=poNumber;
//        this.code=code;
//        this.uom=uom;
//        this.name=name;
//        this.receivedCount=receivedCount;
//        this.totalAmount=totalAmount;
//        this.siteId=siteId;
//        this.itemId=itemId;
//    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getConsumedCount() {
        return consumedCount;
    }

    public void setConsumedCount(int consumedCount) {
        this.consumedCount = consumedCount;
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

    public boolean getConsumed() {
        return isConsumed;
    }

    public void setConsumed(boolean consumed) {
        isConsumed = consumed;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public List<ReceivedItems> getReceivedItems() {
        return receivedItems;
    }

    public void setReceivedItems(List<ReceivedItems> receivedItems) {
        this.receivedItems = receivedItems;
    }



//	
//		public static OrderItems fromDTO(Orders existingOrders, Item sationaryItem) {
//			  OrderItems orderItems=new OrderItems();
//		        orderItems.setOrderId(existingOrders.get_id());
//		        orderItems.setPoNumber(existingOrders.getPoNumber());
//		        orderItems.setName(existingOrders.getSiteName());
//		        orderItems.setCode(sationaryItem.getCode());
//		        orderItems.setUom(sationaryItem.getUom());
//		        orderItems.setSiteId(existingOrders.getSiteId());
//		        orderItems.setItemId(sationaryItem.getItemId());
//		        orderItems.setConsumedCount(sationaryItem.getConsumedCount());
//		      orderItems.setReceivedCount(sationaryItem.getCount());
//		        orderItems.setTotalAmount(existingOrders.getTotalAmount());
//		       // orderItems.setConsumed(sationaryItem.getConsumed());
//		       // orderItems.setStatus(sationaryItem.getStatus);
//		       // orderItems.setReceivedItems(mapReceivedItemsDTOToReceivedItems1(existingOrders.getItem()));
//		        orderItems.setReceivedItems(mapReceivedItemsDTOArray(list<sationaryItem>));
//		        return orderItems;
//
//		}
		
		
		public static OrderItems fromDTO(Orders existingOrders, Item stationaryItem, OrderItemsDTONew orderItemsDTONew) {
		    OrderItems orderItems = new OrderItems();
		    orderItems.setOrderId(existingOrders.get_id());
		    orderItems.setPoNumber(existingOrders.getPoNumber());
		    orderItems.setName(existingOrders.getSiteName());
		    orderItems.setCode(stationaryItem.getCode());
		    orderItems.setUom(stationaryItem.getUom());
		    orderItems.setSiteId(existingOrders.getSiteId());
		    orderItems.setItemId(stationaryItem.getItemId());
		    orderItems.setConsumedCount(stationaryItem.getConsumedCount());
		    orderItems.setReceivedCount(stationaryItem.getQuantity());
		    orderItems.setTotalAmount(existingOrders.getTotalAmount());
//            orderItems.setRef(existingOrders.getRef);
///Arrays.asList(item)
		    // Assuming you have a method mapReceivedItemsDTOArray to convert List<Item> to List<ReceivedItems>
		   // orderItems.setReceivedItems(mapReceivedItemsDTOArray(orderItemsDTONew.getItem()));
		    orderItems.setReceivedItems(mapReceivedItemsDTOArray(Arrays.asList(stationaryItem)));

		    return orderItems;
		}


	






}
