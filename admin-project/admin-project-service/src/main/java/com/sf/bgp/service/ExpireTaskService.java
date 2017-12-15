package com.sf.bgp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 延时实现类
 * @author  jacky
 * @date  2016.12.13
 */
@Service
public class ExpireTaskService {
	private Logger log = LoggerFactory.getLogger(getClass());


	
	public void  expireHandle(){
		log.info("expireHandle start");
	}
}
