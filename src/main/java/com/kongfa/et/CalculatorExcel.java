package com.kongfa.et;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class CalculatorExcel {
    @DataProvider(name = "post")
    public Object[][] post() throws IOException {

        //Excel表格中的sheet页来填写数字参数，第一页下标为0
        return ReadExcel.readExData("E:\\idea-java\\Testdemo1\\src\\main\\resources\\userCase.xls",0);

    }
    @Test(dataProvider = "post")
    public void login(String case_name,String method,String url, String  parameter,String resultType,String errno,String error) throws Exception {
            //parameter转成json扔进请求参数里面

        JSONObject jsonObjec=PostByMethodUtil.SendPostByJson("",parameter);

        }

    public static void main(String[] args) {
        Random random=new Random();
        int c=(int)(Math.random()*10);

        System.out.println(c);
    }
    }


