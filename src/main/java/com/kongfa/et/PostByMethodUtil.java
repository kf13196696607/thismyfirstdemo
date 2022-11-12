package com.kongfa.et;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostByMethodUtil {
    private CloseableHttpClient closeableHttpClient;
    private CloseableHttpResponse closeableHttpResponse;

    public JSONObject SendPostByJson(String url, Object object, HashMap<String,String>heads) throws Exception {
        closeableHttpClient=HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        JSONObject jsonObject=null;
        try {
        //将object转成字符串
            String json= (String) object;
            StringEntity stringEntity=new StringEntity(json,"utf-8");
            //设置json请求方式
            stringEntity.setContentType("application/json");
            //httpPost.setHeader("","");
            httpPost.setEntity(stringEntity);
            if(heads!=null){
                for (Map.Entry<String,String> entity:heads.entrySet()
                     ) {
                    httpPost.addHeader(entity.getKey(),entity.getValue());
                }
            }
            closeableHttpResponse=closeableHttpClient.execute(httpPost);
            HttpEntity response=closeableHttpResponse.getEntity();
            String resultjson= EntityUtils.toString(response,"utf-8");
            EntityUtils.consume(response);
             jsonObject=JSONObject.parseObject(resultjson);

        } finally {
            closeableHttpClient.close();
            closeableHttpResponse.close();
        }
                return jsonObject ;
    }
    public static JSONObject SendPostByJson(String url, Object object) throws Exception {
        JdbcUtil.conn("select");
            return  SendPostByJson(url,object);
        }
}

