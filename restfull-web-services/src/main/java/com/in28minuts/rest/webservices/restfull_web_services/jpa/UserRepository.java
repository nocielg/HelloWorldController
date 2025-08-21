package com.in28minuts.rest.webservices.restfull_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minuts.rest.webservices.restfull_web_services.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
