package com.mocott.smp.base.model;

import java.util.Date;

/**
 * Created by xulei on 2018/2/17.
 */
public class FeedReplyInfo {
    /**留言编号*/
    private java.lang.String feedbackid;
    /**反馈内容*/
    private java.lang.String replyContent;
    /**反馈时间*/
    private java.util.Date replyTime;

    public String getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(String feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
