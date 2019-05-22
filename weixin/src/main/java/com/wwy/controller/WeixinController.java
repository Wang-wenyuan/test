package com.wwy.controller;
import com.thoughtworks.xstream.XStream;
import com.wwy.domain.BaseMessage;
import com.wwy.domain.TextMessage;
import com.wwy.service.WeixinService;
import com.wwy.utils.WeiXinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Controller
@RequestMapping("/weixin")
public class WeixinController {
    @Autowired
    private WeixinService weixinService;
    /**
     * 微信接入认证
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "/authentication.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String authentication(String signature,String timestamp,String nonce,String echostr){
        System.out.println("signature:"+signature+" timestamp:"+timestamp+" nonce:"+nonce+" echostr:"+echostr);
        String token = "weixin";
        try {
            String sha1 = WeiXinUtils.getSHA1(token, timestamp, nonce);
            if(sha1.equals(signature)){
                System.out.println("验证成功");
            }else {
                return null;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return echostr;
    }

    /**
     * 接收公众号消息
     * @param
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>1348831860</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     *   <Content><![CDATA[this is a test]]></Content>
     *   <MsgId>1234567890123456</MsgId>
     * </xml>
     */
    @PostMapping(value = "/authentication.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String authentication(HttpServletRequest request){
        try {
            ServletInputStream inputStream = request.getInputStream();
            Map<String, String> map = weixinService.getXMLMap(inputStream);
            System.out.println(map);
            if(map==null){
                System.out.println("map为空");
                return null;
            }
            BaseMessage message = null;
            //根据消息类型调用不同的方法
            switch (map.get("MsgType")){
                case "text":
                    String content = weixinService.getTuLingResult(map.get("Content"));
                    message = weixinService.dealTextMessage(map,content);
                    break;
                case "image":
                    break;
                case "voice":
                    break;
                case "video":
                    break;
                case "shortvideo":
                    break;
                case "location":
                    break;
                case "link":
                    break;
                case "event":
                    message = weixinService.dealTextMessage(map, "您好,欢迎关注废宅不废");
                    break;
                default:
                    break;
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(TextMessage.class);
            xStream.processAnnotations(BaseMessage.class);
            String xml = xStream.toXML(message);
            return xml;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
