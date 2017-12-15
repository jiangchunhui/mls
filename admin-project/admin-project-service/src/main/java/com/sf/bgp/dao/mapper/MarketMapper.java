package com.sf.bgp.dao.mapper;

import com.sf.bgp.dao.domain.Market;
import com.sf.bgp.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketMapper {

	List<Market> getMarketList();

	Market getMarketDetails(@Param("marketId") long marketId);
}
