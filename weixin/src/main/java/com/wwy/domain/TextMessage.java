package com.wwy.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: wwy
 * @Date: 2019-05-12 11:45
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage{
    @XStreamAlias("Content")
    private String content;

    public TextMessage() {
        super();
    }

    public TextMessage(String content) {
        this.content = content;
    }

    public TextMessage(String toUserName, String fromUserName, String createTime, String msgType, String content) {
        super(toUserName, fromUserName, createTime, msgType);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{} " + super.toString();
    }
}
