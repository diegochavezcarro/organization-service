package com.diego.microdemo.organization.repository;

import com.diego.microdemo.organization.model.Organization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizationRepository extends CrudRepository<Organization,String>  {
   // public Optional<Organization> findById(String organizationId);
}
