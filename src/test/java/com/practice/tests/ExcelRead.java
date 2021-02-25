package com.practice.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void registrationRead() throws IOException {

        String path = "registration.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println(sheet.getRow(1).getCell(1));

        int usedRows = sheet.getPhysicalNumberOfRows();

        int lastUsedRow = sheet.getLastRowNum();


    }
}
