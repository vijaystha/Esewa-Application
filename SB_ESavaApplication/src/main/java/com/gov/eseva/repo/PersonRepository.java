package com.gov.eseva.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gov.eseva.model.Person;

public interface PersonRepository extends JpaRepository<Person, String>{	
}
