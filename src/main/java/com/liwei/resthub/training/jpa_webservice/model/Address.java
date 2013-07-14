package com.liwei.resthub.training.jpa_webservice.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address implements Serializable {
	private String city;
	private String country;

	public Address() {
	}

	public Address(String city, String country) {
		this.city = city;
		this.country = country;
	}

	@NotNull
	@NotEmpty
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@NotNull
	@NotEmpty
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
