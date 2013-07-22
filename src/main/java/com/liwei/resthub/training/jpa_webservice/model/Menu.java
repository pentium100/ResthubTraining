package com.liwei.resthub.training.jpa_webservice.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RooToString
@RooJpaEntity
@RooJson
@RooJavaBean
public class Menu {

	@NotNull
	@NotBlank
	@NotEmpty
	private String text;
	private String controller;
	private String viewer;
	private String param;
	private boolean isLeaf;

	
	@ManyToOne
	private Menu parent;
}
