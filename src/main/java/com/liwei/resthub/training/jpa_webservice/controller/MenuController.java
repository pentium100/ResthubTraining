package com.liwei.resthub.training.jpa_webservice.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.web.controller.ServiceBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liwei.resthub.training.jpa_webservice.model.Menu;
import com.liwei.resthub.training.jpa_webservice.service.MenuService;

@Controller
@RequestMapping(value = "/api/menu")
public class MenuController extends
		ServiceBasedRestController<Menu, Long, MenuService> {

	@Inject
	@Named("menuService")
	@Override
	public void setService(MenuService service) {
		this.service = service;
	}

	@RequestMapping(value = "parent/{parentId}")
	public @ResponseBody
	List<Menu> listByParent(@PathVariable("parentId") Long parentId) {

		Menu parent = service.findById(parentId);

		return service.findByParent(parent);
	}

}