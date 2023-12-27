package com.task.api.service;

import com.task.api.entity.Site;
import com.task.api.entity.StationaryItem;
import com.task.api.entity.StationarySiteItems;
import com.task.api.repository.SiteRepo;
import com.task.api.repository.StationaryItemRepo;
import com.task.api.repository.StationarySiteItemRepo;
import com.task.api.utility.ExcelReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class ApiService {
    private final SiteRepo siteRepo;
    private final StationaryItemRepo stationaryItemRepo;
    private final StationarySiteItemRepo stationarySiteItemRepo;
    
    

    public ApiService(SiteRepo siteRepo, StationaryItemRepo stationaryItemRepo, StationarySiteItemRepo stationarySiteItemRepo) {
        this.siteRepo = siteRepo;
        this.stationaryItemRepo = stationaryItemRepo;
        this.stationarySiteItemRepo = stationarySiteItemRepo;
    }

    public List<Site> getAllActiveSites() {
        return siteRepo.findAllByStatus("ACTIVE");
    }
    public List<StationaryItem> getAllStationary(){
        return (List<StationaryItem>) stationaryItemRepo.findAll();
    }
    
//    private MongoTemplate mongoTemplate;
//    @Autowired
//    public void setMongoTemplate(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }


    public void processExcelFile(MultipartFile excelFile) throws IOException {

        try {

            List<StationaryItem> excelData = ExcelReader.readFromExcel((InputStream) excelFile);

//            if (stationaryItemRepo.existsByName(excelItem.getName().toLowerCase().trim())) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                        "Item with name '" + excelFile.getName() + "' already exists.");
//            }
            for (StationaryItem excelItem : excelData) {
                System.out.println("Processing item: " + excelItem.getName());

                StationaryItem newItem = new StationaryItem((List<StationaryItem>) excelItem);
                newItem.setName(excelItem.getName().toLowerCase().trim());
                newItem.setCode(excelItem.getCode());
                newItem.setUom(excelItem.getUom());
                newItem.setViewedBy(excelItem.getViewedBy());
                newItem.setAlertCount(excelItem.getAlertCount());
                newItem.setCreatedOn(new Date());

                StationaryItem savedItem = stationaryItemRepo.save(newItem);

                System.out.println("Saved item: " + savedItem.getName());

//
            }

        } catch (IllegalArgumentException e) {
            throw  e;
        }
    }

    
}




















//                if (StringUtils.isBlank(excelItem.getName())) {
//                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a valid name.");
//                }

// Validation: Check if numeric format is provided for a specific field (e.g., alertCount)
//            if (!StringUtils.isNumeric(excelItem.getAlertCount())) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter a valid numeric format for alertCount.");
//            }

//            if (excelItem != null && !StringUtils.isNumeric(String.valueOf(excelItem.getAlertCount()))) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter a valid numeric format for alertCount.");
//            }

//                if (stationaryItemRepo.existsByName(excelItem.getName().toLowerCase().trim())) {
//                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                            "Item with name '" + excelFile.getName() + "' already exists.");
//                }





// Create and save StationarySiteItem
//                List<Site> activeSites = getAllActiveSites();
//
//                for (Site site : activeSites) {
//                    StationarySiteItems siteItem = new StationarySiteItems();
//                    siteItem.setItemId(savedItem.get_id());
//                    siteItem.setItemName(savedItem.getName());
//                    siteItem.setSiteId(site.get_id());
//                    siteItem.setSiteName(site.getSiteName());
//                    siteItem.setAlertCount(savedItem.getAlertCount());
//                    siteItem.setAvailableCount(0);
//                    siteItem.setItemPrice(0.0);
//                    siteItem.setStatus("ACTIVE");
//                    siteItem.setCreatedOn(new Date());
//
//                    stationarySiteItemRepo.save(siteItem);
////                System.out.println(siteItem);
//
//                    System.out.println("Saved site item: " + siteItem.get_id());
//
//
//                }

