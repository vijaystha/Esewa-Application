package com.gov.eseva.service;

import com.gov.eseva.model.Person;

public interface IPersonService {

	public String enroll(Person person);
	public boolean isPersonExist(String id);
}
