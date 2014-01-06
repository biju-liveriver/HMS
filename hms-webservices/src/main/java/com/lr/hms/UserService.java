package com.lr.hms;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
@Component
@Path("/user")
public class UserService 
{
	
	@Autowired
	
	SecurityService securityService;
 
	@GET
	@Path("/fullName")
	public Response getFullName() {
		 
		String result = securityService.getUserFullName("biju");
 
		return Response.status(200).entity(result).build();
 
	}
   
}
