package com.liwei.resthub.training.jpa_webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwei.resthub.training.jpa_webservice.model.Menu;
import com.liwei.resthub.training.jpa_webservice.model.EndUser;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByParent(Menu parent);
}
