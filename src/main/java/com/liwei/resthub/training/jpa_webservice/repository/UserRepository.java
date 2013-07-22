package com.liwei.resthub.training.jpa_webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwei.resthub.training.jpa_webservice.model.EndUser;

public interface UserRepository extends JpaRepository<EndUser, Long> {

}
