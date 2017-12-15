package com.sf.bgp.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sf.bgp.client.MarketRestService;
import com.sf.bgp.dao.domain.User;
import com.sf.bgp.dao.mapper.UserMapper;
import com.sf.bgp.domain.Group;
import com.sf.bgp.dao.domain.Market;
import com.sf.bgp.dao.mapper.GroupMapper;
import com.sf.bgp.dao.mapper.MarketMapper;
import com.sf.bgp.domain.GroupUser;
import com.sf.framework.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jacky
 * @version 1.0.0
 * @date 2017/12/01
 */
@Service
public class MarketRestServiceImpl implements MarketRestService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarketMapper marketMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<List<Group>> getMarketList() {
        try{
            Result<List<Group>> result =  new Result<>(true);
            List<Group> groupList = groupMapper.getGroupList();
            result.setObj(groupList);
            log.info("getMarketList res:"+result.getObj());
            return result;
        }catch (Exception e){
            log.error("getMarketList error:{}.",e.getMessage());
        }
       return null;
    }

    @Override
    public Result<Map<String,Object>> getMarketDetails(long groupId,long marketId) {
        try{
            Result<Map<String,Object>> result = new Result<>(true);
            Map<String,Object> resMap = Maps.newHashMap();
            Market market = marketMapper.getMarketDetails(marketId);
            Group group =  groupMapper.getGroupDetailsById(groupId);
            //获取团的其他用户信息
            List<GroupUser> groupUserList = groupMapper.getGroupUserByGroupId(groupId);
            List<String> userPortrait = Lists.newArrayList();
            for(GroupUser groupUser:groupUserList){
                User user =  userMapper.getUserById(groupUser.getUser_id());
                userPortrait.add(user.getPortrait());
            }
            resMap.put("market",market);
            resMap.put("group",group);
            resMap.put("num",groupUserList == null?0:groupUserList.size());
            resMap.put("userPortrait",userPortrait);
            result.setObj(resMap);
            log.info("getMarketDetails res:"+result.getObj());
            return result;
        }catch (Exception e){
            log.error("getMarketList error:{}.",e.getMessage());
        }
       return null;
    }

    @Override
    public Result<String> userAddGroup(GroupUser groupUser) {
        log.info("groupUser :"+ JSON.toJSONString(groupUser));
        try{
            Result<String> result =  new Result<>(true);
            if(groupUser == null){
                result.setSuccess(false);
                result.setErrorMessage("groupUser is null");
                return result;
            }
            //插入用户参团
            groupMapper.addGroupUser(groupUser);
            return result;
        }catch (Exception e){
            log.error("getMarketList error:{}.",e.getMessage());
        }
        return null;
    }


}
