package com.liwei.resthub.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.liwei.resthub.training.jpa_webservice.service.NotificationService;

import static org.mockito.Mockito.mock;

@Configuration
@ImportResource({ "classpath*:resthubContext.xml",
		"classpath*:applicationContext.xml" })
@Profile("test")
public class MocksConfiguration {
	@Bean(name = "notificationService")
	public NotificationService mockedNotificationService() {
		return mock(NotificationService.class);
	}
}