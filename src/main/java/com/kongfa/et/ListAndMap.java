package com.kongfa.et;

import org.testng.annotations.DataProvider;

import java.util.*;

public class ListAndMap {



    public static void main(String[] args) {
        ArrayList<String> arrayList =new ArrayList<String>();
        Map map =new HashMap();
        map.put("age",12);
        arrayList.add("zz");
        arrayList.add("cc");
 /*       for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }*/
/*        for (Object o:arrayList
             ) {
            System.out.println(o);
        }*/
/*        Iterator it =arrayList.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
        Iterator iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
                Map.Entry entry= (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+""+entry.getValue());
        }


    }
}
