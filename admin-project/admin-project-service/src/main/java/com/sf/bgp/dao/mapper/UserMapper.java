package com.sf.bgp.dao.mapper;

import com.sf.bgp.dao.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	User getUser(@Param("username") String username);

	int addUser(User user);

	User getUserById(@Param("id") long id);
}
