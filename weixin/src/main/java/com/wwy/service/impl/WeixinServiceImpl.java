package com.wwy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wwy.domain.BaseMessage;
import com.wwy.domain.TextMessage;
import com.wwy.service.WeixinService;
import com.wwy.utils.TuLingJiQIRenUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = "text";
        String createTime = map.get("CreateTime");
        String msgId = map.get("MsgId");
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setMsgType(msgType);
        textMessage.setCreateTime(System.currentTimeMillis()/1000+"");
        textMessage.setContent(text);
        textMessage.setMsgId(msgId);
        textMessage.setCreateTime(createTime);
        return textMessage;
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
