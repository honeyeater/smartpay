package com.mocott.smp.order.service.impl;

import com.mocott.smp.order.service.OrderDrawServiceI;
import com.mocott.smp.order.service.OrderInjectServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xulei on 2018/3/4.
 */
@Service("orderDrawService")
@Transactional
public class OrderDrawServiceImpl implements OrderDrawServiceI{


    /**
     * 提出订单生成
     * @throws Exception
     */
    @Override
    public void generateOrder() throws Exception {

    }


}
