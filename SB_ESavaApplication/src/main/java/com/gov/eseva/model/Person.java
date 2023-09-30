package com.gov.eseva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Person_BirthCerficate_Table")
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "book_ide")
    @GenericGenerator(
     name = "book_ide", 
     strategy = "com.gov.eseva.id.CustomIdGen")
	
	@Column(name="Personid")
	private String personId;
	
	@Column(name="Person_FNAME",length = 15)
	private String firstName;
	@Column(name="Person_LASTNAME",length = 15)
	private String lastName;
	@Column(name="Person_SURNAME",length = 15)
	private String surName;
	@Column(name="Person_DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="Person_CITYNAME",length = 15)
	private String cityName;
	@Transient
	public String date;
	
	public Person(String personId, String firstName, String lastName, String surName, Date dob, String cityName,
			String date) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.surName = surName;
		this.dob = dob;
		this.cityName = cityName;
		this.date = date;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

