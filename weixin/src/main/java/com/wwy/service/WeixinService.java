package com.wwy.service;

import com.wwy.domain.BaseMessage;
import com.wwy.domain.TextMessage;

import javax.servlet.ServletInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * @Author: wwy
 * @Date: 2019-05-12 10:11
 */
public interface WeixinService {
    /**
     * 接受消息,并转换为xml
     * @param inputStream
     * @return
     */
    Map<String,String> getXMLMap(ServletInputStream inputStream);

    /**
     * 处理text文本
     * @param map
     * @return
     */
    BaseMessage dealTextMessage(Map<String,String> map,String text);

    /**
     * 图灵机器人
     * @param text
     * @return
     */
    String getTuLingResult(String text);

}
