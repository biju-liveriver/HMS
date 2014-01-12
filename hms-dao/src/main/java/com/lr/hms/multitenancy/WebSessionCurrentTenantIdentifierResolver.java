package com.lr.hms.multitenancy;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebSessionCurrentTenantIdentifierResolver implements
		CurrentTenantIdentifierResolver {

	@Autowired
	private HttpServletRequest request;

	public String resolveCurrentTenantIdentifier() {
		
		WebApplicationContext s = WebApplicationContextUtils
				.getWebApplicationContext(request.getSession()
						.getServletContext());
		
		TenantRef tenantId = s.getBean(TenantRef.class);

		return tenantId.getTenantId();
	}

	public boolean validateExistingCurrentSessions() {
		return false;
	}

}
