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

	List<Group> getExpireGroup();

	int addGroup(Group group);

	int updateFinishStatus(@Param("id") long id,@Param("finish") int finish);
}
