package com.wwy.service.impl;

import com.wwy.service.WeixinService;
import org.junit.Test;

/**
 * @Author: wwy
 * @Date: 2019-05-22 9:08
 */
public class WeiXinTest {
    private WeixinService weixinService = new WeixinServiceImpl();
    @Test
    public void method1(){
        String str = weixinService.getTuLingResult("你好啊");
        System.out.println(str);
    }
}
