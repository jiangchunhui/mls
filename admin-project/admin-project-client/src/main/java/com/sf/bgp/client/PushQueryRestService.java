package com.sf.bgp.client;

import com.sf.bgp.domain.PushDomin;
import com.sf.framework.domain.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author jacky
 * @version 1.0.0
 * @date 2017/11/29
 */
@Path("/push")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
public interface PushQueryRestService {

    @GET
    @Path("getPushArrivalRate")
    Result<String> getPushArrivalRate(@DefaultValue("")@QueryParam("time") String time, @DefaultValue("0")@QueryParam("start") int start, @DefaultValue("20")@QueryParam("pageSize") int pageSize);

    @POST
    @Path("postRequest")
    Result<String> getPushArrivalRates(PushDomin pushDomin);
}
