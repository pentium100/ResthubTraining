package com.liwei.resthub.training.jpa_webservice.repository.integration;

import javax.inject.Inject;
import javax.inject.Named;

import org.fest.assertions.api.Assertions;
import org.resthub.test.AbstractTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.TransactionSystemException;
import org.testng.annotations.Test;

import com.liwei.resthub.training.jpa_webservice.model.Address;
import com.liwei.resthub.training.jpa_webservice.model.EndUser;
import com.liwei.resthub.training.jpa_webservice.repository.UserRepository;

@ActiveProfiles({ "test", "resthub-jpa" })
public class UserRepositoryIntegrationTest extends AbstractTest {

	@Inject
	@Named("userRepository")
	private UserRepository repository;

	@Test
	public void testCreateValidAddress() {
		EndUser endUser = new EndUser("userName", "user.email@test.org");
		Address address = new Address();
		address.setCity("city1");
		address.setCountry("country1");
		endUser.setAddress(address);

		endUser = this.repository.save(endUser);
		Assertions.assertThat(endUser).isNotNull();
		Assertions.assertThat(endUser.getId()).isNotNull();
		Assertions.assertThat(endUser.getAddress()).isNotNull();
		Assertions.assertThat(endUser.getAddress().getCity()).isEqualTo("city1");
	}

	@Test
	public void testCreateNullAddress() {
		EndUser endUser = new EndUser("userName", "user.email@test.org");

		endUser = this.repository.save(endUser);

		endUser = this.repository.findOne(endUser.getId());
		Assertions.assertThat(endUser).isNotNull();
		Assertions.assertThat(endUser.getId()).isNotNull();
		Assertions.assertThat(endUser.getAddress()).isNull();
	}

	@Test(expectedExceptions = { TransactionSystemException.class })
	public void testCreateInvalidAddress() {
		EndUser endUser = new EndUser("userName", "user.email@test.org");
		Address address = new Address();
		address.setCity("city1");
		endUser.setAddress(address);

		this.repository.save(endUser);
	}

}