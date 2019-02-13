package com.rahal.autorizationserver.repository;

import org.springframework.data.repository.CrudRepository;
import com.rahal.autorizationserver.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
