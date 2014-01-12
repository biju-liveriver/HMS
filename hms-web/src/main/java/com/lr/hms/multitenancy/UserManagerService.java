package com.lr.hms.multitenancy;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lr.hms.JSONObject;
import com.lr.hms.domain.User;

@Component
@Path("/userManager")
public class UserManagerService {

	@Autowired
	MultitenantService multitenantService;
	
	@Autowired
	TenantRef tenantRef;
	
	@POST
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(JSONObject jsonObject) {
		
		String clinicName = jsonObject.clinicName;
		String userName = jsonObject.userName;
		
		tenantRef.setTenantId(clinicName);
		
		User user = new User();
		user.setUserName(userName);
		multitenantService.save(user);
		
		return Response.status(200).entity("User has been created").build();
	}
}
