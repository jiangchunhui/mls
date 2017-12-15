package com.sf.bgp.job;

import com.sf.bgp.service.ExpireTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 延迟定时任务处理
 * @author  jacky
 * @date  2017.11.13
 */
public class ExpireTaskExecutorJob {
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	ExpireTaskService expireTaskService;

	/**
	 * 定时调用方法
	 */
	public void execute() {
		expireTaskService.expireHandle();

	}

	public ExpireTaskService getExpireTaskService() {
		return expireTaskService;
	}

	public void setExpireTaskService(ExpireTaskService expireTaskService) {
		this.expireTaskService = expireTaskService;
	}
}
