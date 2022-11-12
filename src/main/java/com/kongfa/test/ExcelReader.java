package com.kongfa.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    /**
     * 读取excel文件，excel中不含合并单元格
     * @param path
     * @param sheetname
     * excel表格要注意每行的最后一格不能为空
     * 如果要为空，则需要手动随便填写字符，然后再按del键删除才可以
     * 目前没找到这个解决办法，后续会继续查找解决办法
     * @return
     */
    public static String[][] getExpectationData(String path,String sheetname){
        try{
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            // System.out.println("创建工作表对象");
            //POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fis);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            //System.out.println("创建工作表对象01");
            //得到工作表
            XSSFSheet sheet1 = workBook.getSheet(sheetname);
            //得到总行数
            int rowNum = sheet1.getLastRowNum();
            List<String[]> results = new ArrayList<String[]>();
            for (int i=1;i<=rowNum;i++){
                //当前行
                XSSFRow row = sheet1.getRow(i);
                int colNum = row.getLastCellNum();
                String[] data = new String[colNum];
                //当前行所有列
                for (int j = 0; j < colNum; j++) {
                    try {
                        data[j] = getCellValue(row.getCell(j));
                    }catch (NullPointerException e){ //如果单元格为空的时候，则用这个来处理
                        data[j] = "";
                    }
                }
                //把data[]数组的数据存在list<[]>中
                results.add(data);
                //   for(String[] str:results){
                //     for(int n =0;n<str.length;n++){
                //      System.out.println(str[n]);
                //  }
                // }
            }
            fis.close();


            //将列表转化为二维数组
            String[][] returnArray = new String[results.size()][];
            for (int i = 0; i < returnArray.length; i++) {
                returnArray[i] = (String[]) results.get(i);
                // for(int j = 0;j < returnArray[i].length;j++){
                //   System.out.println(returnArray[i][j]);
                // }

            }
            return returnArray;
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 对Excel的各个单元格的格式进行判断并转换
     */
    public static String getCellValue(XSSFCell cell) {
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                cellValue =cell.getRichStringCellValue().getString().trim();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                cellValue =df.format(cell.getNumericCellValue()).toString();
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                cellValue =cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }

/*    public static void main(String[] args) {
        String[][] strings=ExcelReader.getExpectationData("C:\\Users\\Shine'lon\\Desktop\\查询所属地.xlsx","0");
        System.out.println(strings);
    }*/
}
