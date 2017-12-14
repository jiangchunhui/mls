package com.sf.bgp.client;

import com.sf.bgp.domain.UserInfo;
import com.sf.framework.domain.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author jacky
 * @version 1.0.0
 * @date 2017/11/29
 */
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
public interface UserRestService {

    @POST
    @Path("dologin")
    Result<String> dologin(UserInfo user);
}
