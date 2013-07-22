package com.liwei.resthub.training.jpa_webservice.service;

import java.util.List;

import org.resthub.common.service.CrudService;

import com.liwei.resthub.training.jpa_webservice.model.Menu;
import com.liwei.resthub.training.jpa_webservice.model.Task;

public interface MenuService extends CrudService<Menu, Long> {

	public abstract List<Menu> findByParent(Menu parent);

}