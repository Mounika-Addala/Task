package excelReader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.task.api.dto.StationaryItemRequest;
import com.task.api.entity.StationaryItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ExcelReader {

    public static List<StationaryItem> readFromExcel(InputStream excelFile) {
        List<StationaryItem> entities = new ArrayList<>();   	

        try (Workbook workbook1 = WorkbookFactory.create(excelFile)) {
            Sheet sheet = workbook1.getSheetAt(0);           
            
            boolean isFirstRow = true;

            for (Row row : sheet) {
                // Skip the first row
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }



                // Assuming StationaryItem constructor takes individual parameters
                StationaryItem item = new StationaryItem(
                    getStringValue(row.getCell(0)),
                    toNumber1(row.getCell(1)),
                    getStringValue(row.getCell(2)),
                    getStringValue(row.getCell(3)),
                    toNumber1(row.getCell(4))
                );
                // Set other fields as needed

                entities.add(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return entities;
    }



    public static List<String> checkValidationsExcel(InputStream excelFile) {
        List<String> validationErrors = new ArrayList<>();

        try (Workbook workbook1 = WorkbookFactory.create(excelFile)) {
            Sheet sheet = workbook1.getSheetAt(0);

            boolean isFirstRow = true;

            for (Row row : sheet) {
                // Skip the first row
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                Cell nameCell = row.getCell(0);
                if (nameCell == null || nameCell.getCellType() != CellType.STRING || nameCell.getStringCellValue().trim().isEmpty()) {
                    validationErrors.add("Name is required.");
                    return validationErrors;
                }


                Cell code = row.getCell(1);

                if (code == null ) {

                    validationErrors.add("code is required.");
                    return validationErrors;
                }
                else if (code.getCellType() != CellType.NUMERIC) {
                    validationErrors.add("code should be numeric.");
                    return validationErrors;
                }
                Cell uom = row.getCell(2);
                if (uom == null || uom.getCellType() != CellType.STRING || uom.getStringCellValue().trim().isEmpty()) {

                    validationErrors.add("uom is required.");
                    return validationErrors;
                }
                Cell viewedBy = row.getCell(3);
                if (viewedBy == null || viewedBy.getCellType() != CellType.STRING || viewedBy.getStringCellValue().trim().isEmpty()) {

                    validationErrors.add("viewby is required.");
                    return validationErrors;
                }

                Cell alertCount = row.getCell(4);
                if (alertCount == null ) {
//                    /|| alertCount.getCellType() != CellType.STRING || alertCount.getStringCellValue().trim().isEmpty()
                    validationErrors.add("alertCount is required.");
                    return validationErrors;
                }
                else if (alertCount.getCellType() != CellType.NUMERIC) {
                    validationErrors.add("alertCount should be numeric.");
                    return validationErrors;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            validationErrors.add("Error processing the Excel file");
        }

        return validationErrors;
    }




    private static boolean isEmpty(Cell cell) {
        return cell == null || cell.getCellType() == CellType.BLANK;
    }

    private static String getStringValue(Cell cell) {
    if (cell == null) {
        return null;
    }

    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue();
        case NUMERIC:
            return String.valueOf(cell.getNumericCellValue());
        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());
        case FORMULA:
            return cell.getCellFormula();
        default:
            return null;
    }
}



private static int toNumber1(Cell cell) {
    if (cell != null) {
        switch (cell.getCellType()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            default:
                // Handle other cell types, or return a default value
                return 0;
        }
    }
    // Return a default value or throw an exception if needed
    return 0;
}

}























  //  List<String> errors = validateRow(row);
//                if (!errors.isEmpty()) {
//
//                    throw new IllegalArgumentException(String.join(", ", errors));
//                }


//    private static List<String> validateRow(Row row) {
//        List<String> errors = new ArrayList<>();
//
//        // Validate name
//        if (isEmpty(row.getCell(0))) {
//            errors.add("Please provide the valid name");
//        }
//        if(isEmpty (row.getCell(1))){
//            errors.add("please provide valid code");
//        }
//        if(isEmpty(row.getCell(2))){
//            errors.add("please provide valid uom");
//        }
//        if(isEmpty(row.getCell(3))){
//            errors.add("please provide valid viewedBy");
//        }
//        if(isEmpty(row.getCell(4))){
//            errors.add("please provide valid alertCount");
//        }
//        return errors;
//    }