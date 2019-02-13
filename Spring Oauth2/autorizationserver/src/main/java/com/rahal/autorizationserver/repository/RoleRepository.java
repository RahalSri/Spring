package com.rahal.autorizationserver.repository;

import org.springframework.data.repository.CrudRepository;
import com.rahal.autorizationserver.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
