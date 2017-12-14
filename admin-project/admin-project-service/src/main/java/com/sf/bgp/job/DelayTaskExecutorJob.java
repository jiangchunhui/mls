package com.sf.bgp.job;

import com.sf.bgp.service.DelayTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 延迟定时任务处理
 * @author  jacky
 * @date  2017.11.13
 */
public class DelayTaskExecutorJob {
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	DelayTaskService delayTaskService;

	/**
	 * 定时调用方法
	 */
	public void execute() {
		delayTaskService.delayHandle();

	}

	public DelayTaskService getDelayTaskService() {
		return delayTaskService;
	}

	public void setDelayTaskService(DelayTaskService delayTaskService) {
		this.delayTaskService = delayTaskService;
	}
}
