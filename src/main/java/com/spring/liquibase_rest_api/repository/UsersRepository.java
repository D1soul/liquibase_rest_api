package com.spring.liquibase_rest_api.repository;

import com.spring.liquibase_rest_api.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <User, Long>{
}
