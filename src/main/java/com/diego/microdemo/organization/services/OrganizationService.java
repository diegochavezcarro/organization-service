package com.diego.microdemo.organization.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.microdemo.organization.model.Organization;
import com.diego.microdemo.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository orgRepository;
	
	public Iterable<Organization> findAll() {
		return orgRepository.findAll();
	}

	public Optional<Organization> getOrg(String organizationId) {
		return orgRepository.findById(organizationId);
	}

	public void saveOrg(Organization org) {
		org.setId(UUID.randomUUID().toString());

		orgRepository.save(org);
	}

	public void updateOrg(Organization org) {
		orgRepository.save(org);

	}

	public void deleteOrg(String orgId) {
		orgRepository.deleteById(orgId);
	}
}
