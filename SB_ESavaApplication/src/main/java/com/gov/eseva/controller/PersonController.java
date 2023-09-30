package com.gov.eseva.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gov.eseva.model.Person;
import com.gov.eseva.service.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
//http://localhost:8081/ESEVA_APP/person/show
	@Autowired
	private IPersonService service;
	
	@RequestMapping("/show")
	public String  getRegPage(Model model) {
		
		model.addAttribute("person", new Person());
		
		return "birth-certificate-register";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String enrollForBirtCertificate(@ModelAttribute  Person person ,Model model) throws ParseException {
		System.out.println(person);
		String date=person.getDate();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		Date dob=format.parse(date);
		person.setDob(dob);
		System.out.println(person);
		
		String id=service.enroll(person);
		model.addAttribute("msg","your Registration successfully with cerficate No.::"+id);
		model.addAttribute("person", new Person());
		return "birth-certificate-register";
	}
	
}
