package com.wbl.pages;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelOperations {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public void setExcelFile(String excelFilePath,String sheetName)
            throws IOException {
        File file =    new File(excelFilePath);

        //Creating object of FileInputStream class to read excel
        FileInputStream inputStream = new FileInputStream (file);

        //creating a workbook instance (.xls file)
        workbook= new XSSFWorkbook (inputStream);

        sheet=workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNumber,int columnNumber){
        //getting the cell value from rowNumber and column Number
        cell =sheet.getRow(rowNumber).getCell(columnNumber);

        return cell.getStringCellValue();
    }

    public int getRowCountInSheet(){
        //getting the count of rows in sheet
        int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        return rowcount;
    }

    public void setCellValue(int rowNum,int columnNum,String
            cellValue,String excelFilePath) throws IOException {
        //creating a new cell in row and writing value to it
        sheet.getRow(rowNum).createCell(columnNum).setCellValue(cellValue);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }

}


