package com.liwei.resthub.training.jpa_webservice.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liwei.resthub.training.jpa_webservice.model.User;
import com.liwei.resthub.training.jpa_webservice.repository.UserRepository;

@Controller
@RequestMapping(value = "/api/user")
public class UserController extends
		RepositoryBasedRestController<User, Long, UserRepository> {

	@Inject
	@Named("userRepository")
	@Override
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

}