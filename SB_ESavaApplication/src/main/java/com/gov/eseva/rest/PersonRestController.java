package com.gov.eseva.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gov.eseva.service.IPersonService;

@RestController
//@RequestMapping("/rest")
public class PersonRestController {

	@Autowired
	private IPersonService service;
	
	
	@GetMapping("/exist/{id}")
	public ResponseEntity<String> isCertExist(@PathVariable String id){
		System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIII"+id);
		ResponseEntity<String> response=null; 
		boolean flag=service.isPersonExist(id);
			if(flag)
				response= new ResponseEntity<String>("valid Person",HttpStatus.OK);
			else{
				response=new ResponseEntity<String>("invalid Person",HttpStatus.BAD_REQUEST);
			}
		return response;
	}
}
