package com.mocott.smp.base.model;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.util.Date;
import java.util.List;

/**
 * Created by xulei on 2018/2/17.
 */
public class FeedbackInfo {

    /**
     * ID
     */
    private java.lang.String id;
    /**
     * 用户名
     */
    private java.lang.String username;
    /**
     * 留言编号
     */
    private java.lang.String feedbackid;
    /**
     * 留言内容
     */
    private java.lang.String content;
    /**
     * 留言标题
     */
    private java.lang.String title;
    /**
     * 问题类型
     */
    private java.lang.String feedtype;
    /**
     * 留言时间
     */
    private java.util.Date feedtime;
    /**
     * 是否反馈
     */
    private java.lang.String isFeedback;
    /**
     * 回复信息
     */
    private List<FeedReplyInfo> feedReplyInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(String feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeedtype() {
        return feedtype;
    }

    public void setFeedtype(String feedtype) {
        this.feedtype = feedtype;
    }

    public Date getFeedtime() {
        return feedtime;
    }

    public void setFeedtime(Date feedtime) {
        this.feedtime = feedtime;
    }

    public String getIsFeedback() {
        return isFeedback;
    }

    public void setIsFeedback(String isFeedback) {
        this.isFeedback = isFeedback;
    }

    public List<FeedReplyInfo> getFeedReplyInfo() {
        return feedReplyInfo;
    }

    public void setFeedReplyInfo(List<FeedReplyInfo> feedReplyInfo) {
        this.feedReplyInfo = feedReplyInfo;
    }
}
