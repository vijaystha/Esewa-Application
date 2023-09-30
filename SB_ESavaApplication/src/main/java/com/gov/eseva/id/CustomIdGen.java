package com.gov.eseva.id;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.gov.eseva.model.Person;

public class CustomIdGen 
implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Person person=(Person) object;
		String pname=person.getFirstName();
		String str=pname.substring(0,2);
		int random1=new Random().nextInt(10000);
		int random2=new Random().nextInt(9999);
		str="B-"+str+"-"+random1+random2;
		return str;
	}

}
