package com.gov.eseva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gov.eseva.model.Person;
import com.gov.eseva.repo.PersonRepository;
import com.gov.eseva.service.IPersonService;

@Transactional
@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonRepository repo;
	
	@Override
	public String enroll(Person person) {
		Person person2= repo.save(person);
		String birthNo=person2.getPersonId();
		return birthNo;
	}
	@Override
	public boolean isPersonExist(String id) {
		boolean flag=repo.existsById(id);
		return flag;
	}
}
