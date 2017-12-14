package com.sf.bgp.service.impl;

import com.alibaba.fastjson.JSON;
import com.sf.bgp.client.PushQueryRestService;
import com.sf.bgp.dao.domain.PushStatists;
import com.sf.bgp.dao.mapper.PushStatistsMapper;
import com.sf.bgp.domain.PushDomin;
import com.sf.framework.domain.Result;
import com.sf.bgp.common.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jacky
 * @version 1.0.0
 * @date 2017/12/01
 */
@Service
public class PushQueryRestServiceImpl implements PushQueryRestService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PushStatistsMapper pushStatistsMapper;

    @Override
    public Result<String> getPushArrivalRate(String time, int start, int pageSize) {
        log.info("getPushArrivalRate time:{},start:{}, pageSize:{}.",time,start,pageSize);
        Result<String> result =  new Result<String>(true);
        String statDate = "";
        if(!"".equals(time)){
            statDate = DateUtil.dateFormat(time);
        }
        List<PushStatists> pushStatistsList =  pushStatistsMapper.getPushArrivalRate(statDate,start,pageSize);
        String resDate = JSON.toJSONString(pushStatistsList);
        log.info("getPushArrivalRate time:{},statDate:{}, pushStatistsList:{}.",time,statDate,resDate);
        result.setObj(resDate);
        return result;
    }

    @Override
    public Result<String> getPushArrivalRates(PushDomin pushDomin) {
        Result<String> result =  new Result<String>(true);
        String statDate = "";
        if(!"".equals(pushDomin.getTime())){
            statDate = DateUtil.dateFormat(pushDomin.getTime());
        }
        List<PushStatists> pushStatistsList =  pushStatistsMapper.getPushArrivalRate(statDate,pushDomin.getStart(),pushDomin.getPageSize());
        String resDate = JSON.toJSONString(pushStatistsList);
        log.info("getPushArrivalRate time:{},statDate:{}, pushStatistsList:{}.",pushDomin.getTime(),statDate,resDate);
        result.setObj(resDate);
        return result;
    }
}
