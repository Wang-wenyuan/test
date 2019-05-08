package com.wwy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelUtils {
    public static void getData(String url){
        File file = new File(url);
        //excel抽象对象
        try {
            XSSFWorkbook wb = new XSSFWorkbook(file);
            //sheets数量
            int numberOfSheets = wb.getNumberOfSheets();
            for(int i=0;i<numberOfSheets;i++){
                XSSFSheet sheetAt = wb.getSheetAt(i);
                int lastRowNum = sheetAt.getLastRowNum();
                for(int j=0;j<lastRowNum;j++){
                    XSSFRow row = sheetAt.getRow(j);
                    short lastCellNum = row.getLastCellNum();
                    for(int z = 0;z<lastCellNum;z++){
                        XSSFCell cell = row.getCell(z);
                        System.out.println(cell);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
