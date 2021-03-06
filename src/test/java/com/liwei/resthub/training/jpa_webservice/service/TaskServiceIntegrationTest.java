package com.liwei.resthub.training.jpa_webservice.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.fest.assertions.api.Assertions;
import org.resthub.test.AbstractTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.liwei.resthub.training.MocksConfiguration;
import com.liwei.resthub.training.jpa_webservice.model.Task;
import com.liwei.resthub.training.jpa_webservice.model.EndUser;
import com.liwei.resthub.training.jpa_webservice.repository.UserRepository;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = MocksConfiguration.class)
@ActiveProfiles({ "test", "resthub-jpa" })
public class TaskServiceIntegrationTest extends AbstractTest {

	@Inject
	@Named("taskService")
	private TaskService taskService;

	@Inject
	@Named("userRepository")
	private UserRepository userRepository;

	@Inject
	@Named("notificationService")
	private NotificationService mockedNotificationService;

	@Test
	public void testAffectTask() {
		EndUser endUser = this.userRepository.save(new EndUser("userName",
				"user.email@test.org"));
		Task task = this.taskService.create(new Task("taskName"));
		this.taskService.affectTaskToUser(task.getId(), endUser.getId());

		task = this.taskService.findById(task.getId());
		Assertions.assertThat(task.getEndUser()).isNotNull();
		Assertions.assertThat(task.getEndUser()).isEqualTo(endUser);

		EndUser newUser = this.userRepository.save(new EndUser("userName2",
				"user2.email@test.org"));

		this.taskService.affectTaskToUser(task.getId(), newUser.getId());

		task = this.taskService.findById(task.getId());
		Assertions.assertThat(task.getEndUser()).isNotNull();
		Assertions.assertThat(task.getEndUser()).isEqualTo(newUser);

		verify(mockedNotificationService, times(3)).send(anyString(),
				anyString());
		verify(mockedNotificationService, times(1)).send("user.email@test.org",
				"The task " + task.getTitle() + " has been affected to you");
		verify(mockedNotificationService, times(1)).send("user.email@test.org",
				"The task " + task.getTitle() + " has been reaffected");
		verify(mockedNotificationService, times(1)).send(
				"user2.email@test.org",
				"The task " + task.getTitle() + " has been affected to you");
	}
}