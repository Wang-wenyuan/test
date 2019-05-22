package com.wwy.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * @Author: wwy
 * @Date: 2019-05-22 10:04
 */
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {
    @XStreamAlias("ArticleCount")
    private String articleCount;
    @XStreamAlias("Articles")
    private List<Articles> articles;

    public NewsMessage(String articleCount, List<Articles> articles) {
        this.articleCount = articleCount;
        this.articles = articles;
    }

    public NewsMessage(String toUserName, String fromUserName, String createTime, String msgType, String articleCount, List<Articles> articles) {
        super(toUserName, fromUserName, createTime, msgType);
        this.articleCount = articleCount;
        this.articles = articles;
    }


    public NewsMessage(){
        super();
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsMessage{" +
                "articleCount='" + articleCount + '\'' +
                ", articles=" + articles +
                "} " + super.toString();
    }
}
