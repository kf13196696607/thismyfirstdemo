package com.kongfa.et;

public class suanfa {
    //递归调用
    public static int diguitest(int i){
        if(i<10){

            return diguitest(i+1);
        }else {
            return 1;
        }

    }
// 冒泡算法
    
    public static void main(String[] args) {
        int i=diguitest(1);
    }
}
