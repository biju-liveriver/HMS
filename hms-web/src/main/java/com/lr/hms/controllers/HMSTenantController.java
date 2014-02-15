package com.lr.hms.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tenant")
public class HMSTenantController {

	@RequestMapping(value = "/{tenantId}", method = RequestMethod.GET)
	@PreAuthorize("@tenantSecurityService.hasPermission(#tenantId)")
	public String authorize(ModelMap model,
			@PathVariable(value = "tenantId") long tenantId) {
		model.addAttribute("message",
				"Able to access application belonging to tenant -" + tenantId);
		return "access";
	}
}
