package com.wwy.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: wwy
 * @Date: 2019-05-22 10:07
 * <Title><![CDATA[title1]]></Title>
 *       <Description><![CDATA[description1]]></Description>
 *       <PicUrl><![CDATA[picurl]]></PicUrl>
 *       <Url><![CDATA[url]]></Url>
 */
@XStreamAlias("item")
public class Articles {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Url")
    private String url;

    public Articles() {
    }

    public Articles(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "title='" + title + '\'' +
                ", Ddescription='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
