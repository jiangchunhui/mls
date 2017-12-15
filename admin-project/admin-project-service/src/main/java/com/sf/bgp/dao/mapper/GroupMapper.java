package com.sf.bgp.dao.mapper;

import com.sf.bgp.domain.Group;
import com.sf.bgp.domain.GroupUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapper {

	List<Group> getGroupList();

	Group getGroupDetailsById(@Param("id") long id);

	List<GroupUser> getGroupUserByGroupId(@Param("group_id") long groupId);

	int addGroupUser(GroupUser groupUser);
}
