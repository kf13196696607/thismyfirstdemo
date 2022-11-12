package com.kongfa.et;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    //遍历excel，sheet参数
    public static Object[][] readExData(String filePath,int sheetId) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        //获取工作簿对象通过文件流读取
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        //获取sheet页
        HSSFSheet sh = wb.getSheetAt(sheetId);
        //获取行
        int numberrow = sh.getPhysicalNumberOfRows();
        //获取列
        int numbercell = sh.getRow(0).getLastCellNum();

        Object[][] dttData = new Object[numberrow][numbercell];
        for(int i=0;i<numberrow;i++){
            if(null==sh.getRow(i)||"".equals(sh.getRow(i))||i==0){
                continue;
            }
            for(int j=0;j<numbercell;j++) {
                if(null==sh.getRow(i).getCell(j)||"".equals(sh.getRow(i).getCell(j))){
                    continue;
                }
                HSSFCell cell = sh.getRow(i).getCell(j);
                cell.setCellType(CellType.STRING);
                dttData[i][j] = cell.getStringCellValue();

            }
        }
        return dttData;
    }


}
