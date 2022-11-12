package com.kongfa.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ToJsonUtil {
    /**
     *  @param responseJson 这个变量是拿到响应字符串通过 json 转换成 “json对象”
     *  @param jpath 是要查询 json对象 的值的路径
     *  json与数组嵌套的取值方法：data[1]/first_name
     *  json与json嵌套的取值方法：data/first_name
     *  @return 返回 first_name 这个 json对象 对应的值
     */

    public static String getValueByJPath(JSONObject responseJson, String jpath) {
        Object obj = responseJson;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
                            .get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                }else if (s.contains("{") || s.contains("}")) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\{")[0]))
                            .get(Integer.parseInt(s.split("\\{")[1].replaceAll("}", "")));
                }
            }
        }
        return obj.toString();
    }



}
