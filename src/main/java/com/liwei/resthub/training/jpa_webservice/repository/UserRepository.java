package com.liwei.resthub.training.jpa_webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwei.resthub.training.jpa_webservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
