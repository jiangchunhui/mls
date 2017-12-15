package com.sf.bgp.service.impl;

import com.alibaba.fastjson.JSON;
import com.sf.bgp.client.UserRestService;
import com.sf.bgp.dao.domain.User;
import com.sf.bgp.dao.mapper.PushStatistsMapper;
import com.sf.bgp.dao.mapper.UserMapper;
import com.sf.bgp.domain.UserInfo;
import com.sf.framework.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author jacky
 * @version 1.0.0
 * @date 2017/12/01
 */
@Service
public class UserRestServiceImpl implements UserRestService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<String> dologin(UserInfo userInfo) {
        Result<String> result =  new Result<String>(true);
        if(userInfo == null || StringUtils.isEmpty(userInfo.getUsername())){
            result.setSuccess(false);
            result.setErrorMessage("param is error");
            return result;
        }
        User user = userMapper.getUser(userInfo.getUsername());
        if(user == null){
            //新增一个用户
            user = new User();
            user.setUsername(userInfo.getUsername());
            user.setPortrait("http://10.2.4.129/UI/%E6%89%80%E9%9C%80%E5%9B%BE%E6%A0%87/%E4%BA%BA@2x.png");
            userMapper.addUser(user);
        }
        result.setObj(JSON.toJSONString(user));
        return result;
    }
}
