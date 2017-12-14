package com.sf.bgp.service;

import com.sf.bgp.common.JodisUtils;
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
public class DelayTaskService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JodisUtils jodisUtils;


	
	public void  delayHandle(){
		/*String lockkey = jodisUtils.getLockKey("delayHandle");
		try(Jedis jedis = jodisUtils.getJedis()){
			if(!jodisUtils.lock(jedis,lockkey)){
				log.info("can not get a codis lock");
				return;
			}
			for (int i = 0; i < 10; i++) {
				Set<String> keysSet = jedis.hkeys("delay"+i);
				if(keysSet!=null && !keysSet.isEmpty()){
					for (String key:keysSet){
						Map<String, String> pushInfoMap = jedis.hgetAll(key);
						if(pushInfoMap != null && !pushInfoMap.isEmpty()) {
							String finishedTime = jedis.hget("delay"+i,key);
							pushLogProcessor.getArrivalRate(pushInfoMap, Long.valueOf(finishedTime), jedis);
							jedis.hdel("delay"+i,key);
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error("kafka consumer exception:{}",e);
		}finally {
			jodisUtils.unlock(lockkey);
		}*/
	}
}
