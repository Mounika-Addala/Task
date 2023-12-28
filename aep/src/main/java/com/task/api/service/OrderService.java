package com.task.api.service;

import com.task.api.dto.OrderRequest;
import com.task.api.entity.Orders;
import com.task.api.entity.StationaryItem;
import com.task.api.repository.OrderItemsRepo;
import com.task.api.repository.OrdersRepo;
import com.task.api.repository.StationaryItemRepo;
import com.task.api.utility.ExcelReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrdersRepo ordersRepo;
    private final OrderItemsRepo orderItemsRepo;

    public OrderService(OrdersRepo ordersRepo, OrderItemsRepo orderItemsRepo) {
        this.ordersRepo = ordersRepo;
        this.orderItemsRepo = orderItemsRepo;
    }
   // public List<StationaryItem> getAllStationary(){
   //     return (List<StationaryItem>) stationaryItemRepo.findAll();
    //}

    public List<Orders> getAllOrders(){
        return (List<Orders>) ordersRepo.findAll();
    }

    public Orders newOrder(OrderRequest orderRequest) {
        Orders orders = new Orders(orderRequest);
        orders.setInvoiceNumber(orderRequest.getInvoiceNumber());
        orders.setPoNumber(orderRequest.getPoNumber());
        orders.setSiteName(orderRequest.getSiteName());
        orders.setSiteId(orderRequest.getSiteId());
        orders.setInvoiceDate(orderRequest.getInvoiceDate());
        orders.setInvoiceFile(orderRequest.getInvoiceFile());
        orders.setVendorName(orderRequest.getVendorName());

        orders.setInvoiceDate(new Date());
        Orders saveOrder = ordersRepo.save(orders);

        return saveOrder;
    }
}


//    public void processFile(MultipartFile excelFile) throws Exception{
//        try {
//
//            InputStream excelFiles;
//
//            List<Orders> excelData=ExcelReader.readFromExcel(excelFiles, ordersRepo);
//
//        }
//    }
//
//}


//    public void processExcelFile(MultipartFile excelFile) throws IOException {
//
//        try {
//            List<StationaryItem> excelData = ExcelReader.readFromExcel((InputStream) excelFile,stationaryItemRepo);
//
//            for (StationaryItem excelItem : excelData) {
//                System.out.println("Processing item: " + excelItem.getName());
//
//                StationaryItem newItem = new StationaryItem((List<StationaryItem>) excelItem);
//                newItem.setName(excelItem.getName().toLowerCase().trim());
//                newItem.setCode(excelItem.getCode());
//                newItem.setUom(excelItem.getUom());
//                newItem.setViewedBy(excelItem.getViewedBy());
//                newItem.setAlertCount(excelItem.getAlertCount());
//                newItem.setCreatedOn(new Date());
//
//                StationaryItem savedItem = stationaryItemRepo.save(newItem);
//
//                System.out.println("Saved item: " + savedItem.getName());
//
//            }
//
//        } catch (IllegalArgumentException e) {
//            throw  e;
//        }
//
//
