package com.lr.hms.multitenancy;

import javax.ws.rs.core.MediaType;

import com.lr.hms.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * This class has been created to test CreateUser
 */

public class TestUserManager {

	public static void main(String[] args) {

		createUser("clinic1", "user1");

		createUser("clinic2", "user2");
	}

	private static void createUser(String clinicName, String userName) {

		JSONObject input = new JSONObject(clinicName, userName);

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);

		Client client = Client.create(clientConfig);

		WebResource webResource = client
				.resource("http://localhost:8080/hms/rest/userManager/createUser");

		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, input);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed: HTTP error code: "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}
}
