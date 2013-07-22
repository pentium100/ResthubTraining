package com.liwei.resthub.training.jpa_webservice;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.util.PostInitialize;
import org.springframework.transaction.annotation.Transactional;

import com.liwei.resthub.training.jpa_webservice.model.Menu;
import com.liwei.resthub.training.jpa_webservice.model.Task;
import com.liwei.resthub.training.jpa_webservice.model.EndUser;
import com.liwei.resthub.training.jpa_webservice.repository.MenuRepository;
import com.liwei.resthub.training.jpa_webservice.repository.TaskRepository;
import com.liwei.resthub.training.jpa_webservice.repository.UserRepository;

@Named("sampleInitializer")
public class TaskInitializer {

	@Inject
	@Named("taskRepository")
	private TaskRepository taskRepository;

	@Inject
	@Named("userRepository")
	private UserRepository userRepository;

	@Inject
	@Named("menuRepository")
	private MenuRepository menuRepository;

	@PostInitialize
	@Transactional(readOnly = false)
	public void init() {
		EndUser user1 = new EndUser("testUser1", "user1@test.org");
		user1 = userRepository.save(user1);
		EndUser user2 = userRepository.save(new EndUser("testUser2",
				"user2@test.org"));
		taskRepository.save(new Task("testTask1", user1));
		taskRepository.save(new Task("testTask2", user1));
		taskRepository.save(new Task("testTask3", user2));
		taskRepository.save(new Task("testTask4"));

		Menu menu = new Menu();
		menu.setController("controller1");
		menu.setParam("param1");
		menu.setText("menu text");
		menu.setViewer("menu view");
		menu.setIsLeaf(false);
		menu.setParent(null);
		menuRepository.save(menu);

		menu = new Menu();
		menu.setController("controller2");
		menu.setParam("param2");
		menu.setText("menu text2");
		menu.setViewer("menu view2");
		menu.setIsLeaf(false);
		menu.setParent(null);
		menuRepository.save(menu);

		menu = new Menu();
		menu.setController("controller5");
		menu.setParam("param5");
		menu.setText("menu text5");
		menu.setViewer("menu view5");
		menu.setIsLeaf(false);
		menu.setParent(null);
		menuRepository.save(menu);

		Menu subMenu = new Menu();
		subMenu.setController("controller3");
		subMenu.setParam("param#");
		subMenu.setText("menu text3");
		subMenu.setViewer("menu view3");
		subMenu.setParent(menu);
		subMenu.setIsLeaf(true);
		menuRepository.save(subMenu);

		subMenu = new Menu();
		subMenu.setController("controller4");
		subMenu.setParam("param4");
		subMenu.setText("menu text4");
		subMenu.setViewer("menu view4");
		subMenu.setIsLeaf(true);
		subMenu.setParent(menu);
		menuRepository.save(subMenu);

	}
}
