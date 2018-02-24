package com.mocott.smp.base.model;

import java.util.List;

/**
 * 注册用户信息
 * Created by xulei on 2018/2/17.
 */
public class RegisterUserInfo {

    /**
     * 用户名
     */
    private java.lang.String userName;

    /**
     * 真实姓名
     */
    private java.lang.String realName;

    /**
     * 推荐人用户名
     */
    private java.lang.String introducer;

    /**
     * 会员级别
     */
    private java.lang.String userLevel;

    /**
     * 是否有效
     */
    private java.lang.String validstatus;
    /**
     * 推荐注册的用户信息
     */
    private List<RegisterUserInfo> userInfos;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getValidstatus() {
        return validstatus;
    }

    public void setValidstatus(String validstatus) {
        this.validstatus = validstatus;
    }

    public List<RegisterUserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<RegisterUserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
