package com.mocott.smp.util.task;

import com.mocott.smp.order.service.OrderInjectInfoServiceI;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.web.system.sms.service.TSSmsServiceI;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @ClassName:SmsSendTask 订单状态变化更新处理
 * @Description: TODO
 * @author Comsys-skyCc cmzcheng@gmail.com
 * @date 2014-11-13 下午5:06:34
 * 
 */

@Service("orderChangeTask")
public class OrderChangeTask implements Job{
	
	@Autowired
	private OrderInjectInfoServiceI orderInjectInfoServiceI;

	
	/*@Scheduled(cron="0 0/1 * * * ?")*/
	public void run() {
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================订单状态更新开始===================");
		try {
			if(orderInjectInfoServiceI == null) {
				orderInjectInfoServiceI = ApplicationContextUtil.getContext().getBean(OrderInjectInfoServiceI.class);
			}
			orderInjectInfoServiceI.changeOrderStauts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		org.jeecgframework.core.util.LogUtil.info("===================订单状态更新开始===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		org.jeecgframework.core.util.LogUtil.info("总耗时"+times+"毫秒");
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		run();
	}
}
