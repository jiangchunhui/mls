package com.sf.bgp.dao.mapper;

import com.sf.bgp.dao.domain.PushStatists;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PushStatistsMapper {

	int insert(PushStatists pushStatists);

	List<PushStatists> getPushArrivalRate(@Param("statDate") String statDate, @Param("start") int start, @Param("pageSize") int pageSize);
}
