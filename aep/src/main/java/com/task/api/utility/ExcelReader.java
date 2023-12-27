package com.task.api.utility;

import com.task.api.entity.StationaryItem;
import com.task.api.repository.StationaryItemRepo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static excelReader.ExcelReader.toNumber1;

public class ExcelReader {


   // private static StationaryItemRepo stationaryItemRepo;
    StationaryItemRepo stationaryItemRepo;

    public ExcelReader() {
        stationaryItemRepo = new StationaryItemRepo() {
            @Override
            public List<StationaryItem> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<StationaryItem> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends StationaryItem> S save(S entity) {
                return null;
            }

            @Override
            public <S extends StationaryItem> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<StationaryItem> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public List<StationaryItem> findAll() {
                return null;
            }

            @Override
            public List<StationaryItem> findAllById(Iterable<String> strings) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(StationaryItem entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends String> strings) {

            }

            @Override
            public void deleteAll(Iterable<? extends StationaryItem> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends StationaryItem> S insert(S entity) {
                return null;
            }

            @Override
            public <S extends StationaryItem> List<S> insert(Iterable<S> entities) {
                return null;
            }

            @Override
            public <S extends StationaryItem> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends StationaryItem> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends StationaryItem> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends StationaryItem> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends StationaryItem> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends StationaryItem> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends StationaryItem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public boolean existsByName(String itemName) {
                return false;
            }
        };
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


                if (nameCell != null) {
                    nameCell.setCellValue(nameCell.getStringCellValue().toLowerCase().trim());
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

               // String name = getStringValue(row.getCell(0)).toLowerCase().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
            validationErrors.add("Error processing the Excel file");
        }

        return validationErrors;
    }


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

                Cell nameCell = row.getCell(0);
                if (nameCell != null) {
                    String name = nameCell.getStringCellValue().toLowerCase().trim();

                    if (stationaryItemRepo.existsByName(name)) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "Item with name '" + name + "' already exists in the database.");
                    }
                    
                    
//                    if (entities.stream().anyMatch(item -> item.getName().equals(name))) {
//                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                                "Item with name '" + name + "' already exists.");
//                    }

                    // Assuming StationaryItem constructor takes individual parameters
                    StationaryItem item = new StationaryItem(
                            name,
                            // getStringValue(row.getCell(0)).toLowerCase().trim(),

                            toNumber1(row.getCell(1)),
                            getStringValue(row.getCell(2)),
                            getStringValue(row.getCell(3)),
                            toNumber1(row.getCell(4))
                    );
                    // Set other fields as needed

                    entities.add(item);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return entities;
    }
        public static String getStringValue(Cell cell) {
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




// try (InputStream inputStream = file.getInputStream()) {
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            Sheet sheet = workbook.getSheetAt(0);
//
//            Iterator<Row> rowIterator = sheet.iterator();
//            if (rowIterator.hasNext()) {
//                rowIterator.next();
//            }
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                StationaryItemRequest excelItem = mapRowToDTO(row);
//                excelData.add(excelItem);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//        return excelData;
//    }
//
//    private static StationaryItemRequest mapRowToDTO(Row row) {
//        StationaryItemRequest excelItem = new StationaryItemRequest();
//        excelItem.setName(getStringCellValue(row.getCell(0)));
//        excelItem.setCode((int) getNumericCellValue(row.getCell(1)));
//        excelItem.setUom(getStringCellValue(row.getCell(2)));
//        excelItem.setViewedBy(getStringCellValue(row.getCell(3)));
//        excelItem.setAlertCount((int) getNumericCellValue(row.getCell(4)));
//        return excelItem;
//    }
//
//    private static String getStringCellValue(Cell cell) {
//        return cell.getStringCellValue().trim();
//    }
//
//    private static double getNumericCellValue(Cell cell) {
//        return cell.getNumericCellValue();
//    }
//}




 //   String name = nameCell.getStringCellValue().trim();
//                if (existingNames.contains(name)) {
//                    validationErrors.add("Duplicate names are not allowed.");
//                    return validationErrors;
//                }




//     private static String toLowerCaseAndTrim(String name) {
//        return name == null ? null : name.toLowerCase().trim();
//    }