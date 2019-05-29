package com.diego.microdemo.organization.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diego.microdemo.organization.model.Organization;
import com.diego.microdemo.organization.services.OrganizationService;

@RestController
@RequestMapping(value = "v1/organizations", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrganizationServiceController {
	@Autowired
	private OrganizationService orgService;
	private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Organization> getOrganizations() {
		return orgService.findAll();
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
	public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
		logger.debug("Looking up data for org: {}", organizationId);

		Optional<Organization> org = orgService.getOrg(organizationId);
		// org.setContactName(org.getContactName());
		if (org.isPresent()) {
			org.get().setContactName(org.get().getContactName());
			return new ResponseEntity<>(org.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/{organizationId}", consumes = "application/json", method = RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) {
		orgService.updateOrg(org);

	}

	@RequestMapping(value = "/", consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveOrganization(@RequestBody Organization org) {
		orgService.saveOrg(org);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("organizationId") String orgId) {
		orgService.deleteOrg(orgId);

	}
}
