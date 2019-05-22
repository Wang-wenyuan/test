package com.wwy.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author: wwy
 * @Date: 2019-05-22 7:58
 * {
 * 	"reqType":0,
 *     "perception": {
 *         "inputText": {
 *             "text": "附近的酒店"
 *         }
 *     },
 *     "userInfo": {
 *         "apiKey": "",
 *         "userId": ""
 *     }
 * }
 */
public class TuLingJiQIRenUtils {
    //自己的apikey，注意不是密钥
    private static final String key = "5182bb52d9594bcc9b767a38a4d14184";
    //图灵api接口
    private static final String apiUrl = "http://openapi.tuling123.com/openapi/api/v2";
    //用户id
    private static final String userId = "448344";

    /**
     * 发送请求获取返回的结果
     * @param content
     * @return
     */
    public static String getResult(String content) {
        //获取http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建post请求
        HttpPost httpPost = new HttpPost(apiUrl);

        //封装json数据
        Map<String,Object> map = new HashMap<>();
        map.put("reqType",0);
        Map<String,Object> perception = new HashMap<>();
        Map<String,Object> inputText = new HashMap<>();
        inputText.put("text",content);
        perception.put("inputText",inputText);
        map.put("perception",perception);
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("apiKey",key);
        userInfo.put("userId",userId);
        map.put("userInfo",userInfo);
        JSONObject jsonObject = new JSONObject(map);
        //需要发送的json字符串
        String jsonStr = jsonObject.toString();
        StringEntity stringEntity = new StringEntity(jsonStr,"utf-8");
        //放入请求体中
        httpPost.setEntity(stringEntity);
        //响应模型
        CloseableHttpResponse response = null;
        String resultStr = null;
        try {
            //发送请求,得到响应
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity);
            resultStr = new String(str.getBytes("ISO-8859-1"),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStr;
    }


}
