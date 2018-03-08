package com.mocott.smp.order.model;

import java.util.Date;

/**
 * Created by xulei on 2018/3/4.
 * 注入资金订单信息
 */
public class OrderInInfo {

    /**用户名*/
    private java.lang.String username;
    /**订单编号*/
    private java.lang.String orderCode;
    /**订单金额*/
    private java.lang.Double orderMoney;
    /**订单状态*/
    private java.lang.String orderStatus;
    /**订单时间*/
    private java.util.Date orderTime;
    /**应得利息*/
    private java.lang.Double interest;
    /**首付款金额*/
    private java.lang.Double firstPay;
    /**首付款注入时间*/
    private java.util.Date firstPayTime;
    /**尾款金额*/
    private java.lang.Double endPay;
    /**尾款注入时间*/
    private java.util.Date endPayTime;
    /**首尾款区间时间*/
    private java.lang.String firstEndInternal;
    /**保存期区间时间*/
    private java.lang.String saveInternal;
    /**利息比例*/
    private java.lang.Double restRate;
    /**手续费*/
    private java.lang.Double serviceCharge;
    /**实际利息金额*/
    private java.lang.Double interestReal;
    /**等待期开始时间*/
    private java.util.Date waitStartTime;
    /**等待期区间时间*/
    private java.lang.String waitInternal;
    /**等待期结束时间*/
    private java.util.Date waitEndTime;
    /**订单款进度*/
    private java.lang.String orderProgress;
    /**原因*/
    private java.lang.String reason;
    /**订单总款*/
    private java.lang.Double orderTotalMoney;
    /**输入日期*/
    private java.util.Date inputtime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getFirstPay() {
        return firstPay;
    }

    public void setFirstPay(Double firstPay) {
        this.firstPay = firstPay;
    }

    public Date getFirstPayTime() {
        return firstPayTime;
    }

    public void setFirstPayTime(Date firstPayTime) {
        this.firstPayTime = firstPayTime;
    }

    public Double getEndPay() {
        return endPay;
    }

    public void setEndPay(Double endPay) {
        this.endPay = endPay;
    }

    public Date getEndPayTime() {
        return endPayTime;
    }

    public void setEndPayTime(Date endPayTime) {
        this.endPayTime = endPayTime;
    }

    public String getFirstEndInternal() {
        return firstEndInternal;
    }

    public void setFirstEndInternal(String firstEndInternal) {
        this.firstEndInternal = firstEndInternal;
    }

    public String getSaveInternal() {
        return saveInternal;
    }

    public void setSaveInternal(String saveInternal) {
        this.saveInternal = saveInternal;
    }

    public Double getRestRate() {
        return restRate;
    }

    public void setRestRate(Double restRate) {
        this.restRate = restRate;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getInterestReal() {
        return interestReal;
    }

    public void setInterestReal(Double interestReal) {
        this.interestReal = interestReal;
    }

    public Date getWaitStartTime() {
        return waitStartTime;
    }

    public void setWaitStartTime(Date waitStartTime) {
        this.waitStartTime = waitStartTime;
    }

    public String getWaitInternal() {
        return waitInternal;
    }

    public void setWaitInternal(String waitInternal) {
        this.waitInternal = waitInternal;
    }

    public Date getWaitEndTime() {
        return waitEndTime;
    }

    public void setWaitEndTime(Date waitEndTime) {
        this.waitEndTime = waitEndTime;
    }

    public String getOrderProgress() {
        return orderProgress;
    }

    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(Double orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }
}
