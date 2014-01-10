package com.lr.hms;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
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
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(UserDetails userDetails) {
 
		return Response.status(200).entity("Hi"+userDetails.getUserName()+" Welcome to HMS").build();
 
	}
	
   
}
