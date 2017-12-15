package com.sf.bgp.service;

import com.sf.bgp.common.DateUtil;
import com.sf.bgp.dao.domain.Market;
import com.sf.bgp.dao.mapper.GroupMapper;
import com.sf.bgp.dao.mapper.MarketMapper;
import com.sf.bgp.domain.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/** 
 * 延时实现类
 * @author  jacky
 * @date  2016.12.13
 */
@Service
public class ExpireTaskService {
	private Logger log = LoggerFactory.getLogger(getClass());


	@Autowired
	private GroupMapper groupMapper;

	@Autowired
	private MarketMapper marketMapper;
	
	public void  expireHandle(){
		log.info("expireHandle start");
		try{
			List<Group> groupList = groupMapper.getExpireGroup();
			for(Group group:groupList){
				Market market = marketMapper.getMarketDetails(group.getMarket_id());
				Group  newGroup = new Group();
				newGroup.setMarket_id(group.getMarket_id());
				newGroup.setCurrent_count(group.getCurrent_count()+1);
				newGroup.setGroup_name(market.getMkt_name_show()+newGroup.getCurrent_count());
				newGroup.setStart_time(new Date());
				newGroup.setEnd_time(DateUtil.getCurrentTimeBeforeDay(newGroup.getStart_time(),market.getGroup_duration()));
				newGroup.setBanner(group.getBanner());
				groupMapper.addGroup(newGroup);
				//把完成状态设置为2结束
				groupMapper.updateFinishStatus(group.getId(),2);
			}
		}catch (Exception e){
			log.error("expireHandle error:{}.",e.getMessage());
		}

	}


}
