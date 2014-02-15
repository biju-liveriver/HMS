package com.lr.hms.multitenancy;

import org.springframework.stereotype.Component;

@Component("tenantSecurityService")
public class TenantSecurityService {

	public boolean hasPermission(String key) {
		
		//To be loaded from Master Database
		String tenant = "1";		

		if (key.equals(tenant)) {
			return true;
		}

		return false;
	}
}
