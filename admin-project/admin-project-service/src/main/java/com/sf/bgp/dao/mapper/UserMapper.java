package com.sf.bgp.dao.mapper;

import com.sf.bgp.dao.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	User getUser(@Param("username") String username, @Param("password") String password);
}
