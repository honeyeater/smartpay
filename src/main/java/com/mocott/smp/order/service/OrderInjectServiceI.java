package com.mocott.smp.order.service;

import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.model.OrderInInfo;
import com.mocott.smp.user.entity.FrontUserMemberEntity;

/**
 * Created by xulei on 2018/3/4.
 */
public interface OrderInjectServiceI {

    public void generateOrder(OrderInInfo orderInInfo) throws Exception;

    public String getOrderWallet(String userName) throws Exception;

    /**
     * 获取上一订单的类型(如果要产生注入订单,则上一单需是提出订单,如果要产生提取订单,则需上一单是注入订单)
     * @param userName
     * @return
     * @throws Exception
     */
    public String getLastOrderType(String userName) throws Exception;

    /**
     * 转存到钱包中
     * @param orderInject
     * @param userMember
     */
    public void doSaveInWallet(OrderInjectInfoEntity orderInject, FrontUserMemberEntity userMember) throws Exception;
}
