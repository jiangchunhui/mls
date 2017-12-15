package com.sf.bgp.client;

import com.sf.bgp.domain.GroupUser;
import com.sf.framework.domain.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

import com.sf.bgp.domain.Group;

/**
 * @author jacky
 * @version 1.0.0
 * @date 2017/11/29
 */
@Path("/market")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
public interface MarketRestService {

    @POST
    @Path("getMarketList")
    Result<List<Group>> getMarketList();


    @GET
    @Path("getMarketDetails")
    Result<Map<String,Object>> getMarketDetails(@QueryParam("groupId") long groupId,@QueryParam("marketId")  long marketId);

    @POST
    @Path("userAddGroup")
    Result<String> userAddGroup(GroupUser groupUser);

}
