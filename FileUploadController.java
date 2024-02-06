package com.task.api.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import responseEntity.ErrorResponse;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class FileUploadController {

    // Specify the directory on the D drive where you want to save the files
   String UPLOAD_DIR = "G:/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<?>  handleFileUpload(@RequestParam("file") MultipartFile file) {
    	
    	System.out.println(file);
        if (file.isEmpty()) {
            // Handle empty file
           // return "redirect:/error";
//        	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("{\"status\": \"error\", \"message\": \"File is empty\"}");
        	
        	 ErrorResponse responseMessage = new ErrorResponse("error", "File is empty");
             return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                     .body(responseMessage);
        }

        try {
            // Create the directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Save the file to the specified directory on the G drive
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            String originalFilename = file.getOriginalFilename();
          //  String[] fileNameSplit = file.getOriginalFilename().split(".");
            String[] fileNameSplit = originalFilename.split("\\.");
            String finalName = fileNameSplit[0] + System.currentTimeMillis() + "." + fileNameSplit[1];
            String filePath1 = UPLOAD_DIR + finalName;
            
           // String finalName = fileNameSplit[0]+System.currentTimeMillis()+"."+fileNameSplit[1];
           // String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            file.transferTo(new File(filePath1));

            System.out.println("File uploaded to: " + filePath);
           // return "redirect:/success"; 
            
            ErrorResponse responseMessage = new ErrorResponse("success", "File uploaded successfully");
            return ResponseEntity.ok()
                    .body(responseMessage);
            
//            return ResponseEntity.ok()
//                    .body("{\"status\": \"success\", \"message\": \"File uploaded successfully\"}");

        } catch (IOException e) {
            e.printStackTrace();
            // Return a JSON response indicating failure
            ErrorResponse responseMessage = new ErrorResponse("error", "File upload failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseMessage);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("{\"status\": \"error\", \"message\": \"File upload failed\"}");
        }
            
//            return "redirect:/success"; // Redirect to a success page
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "redirect:/error";
//        }
    }
}
