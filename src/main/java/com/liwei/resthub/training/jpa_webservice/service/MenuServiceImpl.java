package com.liwei.resthub.training.jpa_webservice.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.service.CrudServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import com.liwei.resthub.training.jpa_webservice.model.Menu;
import com.liwei.resthub.training.jpa_webservice.repository.MenuRepository;
import com.liwei.resthub.training.jpa_webservice.repository.TaskRepository;

@Transactional
@Named("menuService")
public class MenuServiceImpl extends
		CrudServiceImpl<Menu, Long, MenuRepository> implements MenuService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liwei.resthub.training.jpa_webservice.service.MenuService#findByParent
	 * (com.liwei.resthub.training.jpa_webservice.model.Menu)
	 */
	@Override
	public List<Menu> findByParent(Menu parent) {

		return this.repository.findByParent(parent);
	}

	@Override  
	@Inject
	public void setRepository(MenuRepository menuRepository) {
		super.setRepository(menuRepository);
	}

}
