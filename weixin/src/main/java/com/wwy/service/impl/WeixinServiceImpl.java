package com.wwy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wwy.domain.Articles;
import com.wwy.domain.BaseMessage;
import com.wwy.domain.NewsMessage;
import com.wwy.domain.TextMessage;
import com.wwy.service.WeixinService;
import com.wwy.utils.TuLingJiQIRenUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import java.util.*;

/**
 * @Author: wwy
 * @Date: 2019-05-12 10:13
 */
@Service
public class WeixinServiceImpl implements WeixinService {
    /**
     * 接受微信公共号消息
     * @param inputStream
     * @return
     */
    public Map<String, String> getXMLMap(ServletInputStream inputStream) {
        Map<String,String> map = new HashMap<String, String>();
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                map.put(element.getName(),element.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 处理文本消息
     * @param map
     * @param text
     * @return
     */
    public BaseMessage dealTextMessage(Map<String, String> map,String text) {
        if(text==null && "".equals("")){
            //返回图文消息
            NewsMessage newsMessage = getNewsMessage(map);
            return newsMessage;
        }else{
            //返回文本消息
            TextMessage textMessage = getTextMessage(map, text);
            return textMessage;
        }
    }

    /**
     * 返回文本消息
     * @return
     */
    @Override
    public TextMessage getTextMessage(Map<String,String> map,String text) {
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String createTime = map.get("CreateTime");
        String msgType = "text";
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setMsgType(msgType);
        textMessage.setCreateTime(System.currentTimeMillis()/1000+"");
        textMessage.setContent(text);
        textMessage.setCreateTime(createTime);
        return textMessage;
    }

    /**
     * 返回图文消息
     * http://mmbiz.qpic.cn/mmbiz_jpg/wnBrwkqwibcJjs5wN9jaA9W80wkJib4MZeq5cDWHRtyLj6RALKpZJmVYReX3rnbRFMUXLkibTASwR3d9qtCUmreZA/0
     * @param map
     * @return
     *
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[news]]></MsgType>
     *   <ArticleCount>1</ArticleCount>
     *   <Articles>
     *     <item>
     *       <Title><![CDATA[title1]]></Title>
     *       <Description><![CDATA[description1]]></Description>
     *       <PicUrl><![CDATA[picurl]]></PicUrl>
     *       <Url><![CDATA[url]]></Url>
     *     </item>
     *   </Articles>
     * </xml>
     */
    @Override
    public NewsMessage getNewsMessage(Map<String, String> map) {
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String createTime = map.get("CreateTime");
        String msgType = "news";
        String articleCount = "1";
        String title = "甲铁城的卡巴内瑞";
        String description = "三连";
        String picUrl = "http://mmbiz.qpic.cn/mmbiz_jpg/wnBrwkqwibcJjs5wN9jaA9W80wkJib4MZeW8VymFnBMu0cj4zPStrqLqJUU4ahchOpjMOXZHQzE3RjqDSjpZG8yw/0";
        String url = "https://www.bilibili.com/video/av11556174";
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(createTime);
        newsMessage.setMsgType(msgType);
        newsMessage.setArticleCount(articleCount);
        List<Articles> list = new ArrayList<>();
        Articles articles = new Articles();
        articles.setTitle(title);
        articles.setdescription(description);
        articles.setPicUrl(picUrl);
        articles.setUrl(url);
        list.add(articles);
        newsMessage.setArticles(list);
        return newsMessage;
    }

    /**
     * 图灵机器人
     * @param text
     * @return
     */
    @Override
    public String getTuLingResult(String text) {
        String resultText = null;
        String result = TuLingJiQIRenUtils.getResult(text);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Map<String,Object> resultMap = jsonObject;
        Set<Map.Entry<String, Object>> entries = resultMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            if("intent".equals(key)){
                Map<String,Object> intentMap = (Map<String, Object>) entry.getValue();
                Set<Map.Entry<String, Object>> entryIntent = intentMap.entrySet();
                for (Map.Entry<String, Object> stringObjectEntry : entryIntent) {
                    String intentKey = stringObjectEntry.getKey();
                    if("code".equals(intentKey)){
                        Integer intentKalue = (Integer) stringObjectEntry.getValue();
                        if(intentKalue+"".length()==4){
                            return "服务器错误,请稍后重试";
                        }

                    }
                }
            }
            if("results".equals(key)){
                List<Map<String,Object>> resultsValueList = (List<Map<String, Object>>) entry.getValue();
                for (Map<String, Object> stringObjectMap : resultsValueList) {
                    Set<Map.Entry<String, Object>> entryResults = stringObjectMap.entrySet();
                    for (Map.Entry<String, Object> entryResult : entryResults) {
                        String valuesKey = entryResult.getKey();
                        if("values".equals(valuesKey)){
                            Map<String,Object> textValue = (Map<String, Object>) entryResult.getValue();
                            String resultText1 = (String) textValue.get("text");
                            resultText = resultText1;
                        }
                    }
                }
            }
        }
    return resultText;
    }
}
