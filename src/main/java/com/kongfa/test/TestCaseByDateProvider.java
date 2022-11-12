package com.kongfa.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public  class  TestCaseByDateProvider {
    @DataProvider(name = "post")
    public Object[][] post() throws IOException {

        //Excel表格中的sheet页来填写数字参数，第一页下标为0
        return ExcelReader.getExpectationData("C:\\Users\\Shine'lon\\Desktop\\查询所属地.xlsx","Sheet1");

    }
    @Test(dataProvider = "post")
    public void login(String case_name,String method,String url, String  parameter,String resultType,String errno,String error) throws Exception {
        //parameter转成json扔进请求参数里面
        System.out.println(parameter);
   /*     JSONObject jsonObjec= PostByMethodUtil.SendPostByJson("http://apis.juhe.cn/xzqh/query",parameter);
        System.out.println(jsonObjec);*/
    }



    //静态代码块
    static {
        System.out.println("ss");
    }


}
