package com.wwy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: wwy
 * @Date: 2019-05-16 10:04
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss:SS");
        Date date = new Date();
        String dateString = simpleDateFormat.format(date);
        System.out.println(dateString);
        Date date1 = simpleDateFormat.parse(dateString);
        System.out.println(date1);
        HashMap hashMap = new HashMap();
        hashMap.put(null,"这是一个空");
        hashMap.put("name","张三");
        hashMap.put(null,"这是第二个空");
        hashMap.put("age","12");
        hashMap.put("sex",null);
        System.out.println(hashMap);

    }
}
