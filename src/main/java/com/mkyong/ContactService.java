package com.mkyong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Service
@ApplicationScope
public class ContactService {
	private static Logger log = LoggerFactory.getLogger(ContactService.class);
	private static int counter = 0;
	
	@Autowired
	private ContactRepository contactrepository;
	
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		ContactService.counter = counter;
	}

	public ContactService() {
		System.out.println("Contact bean service saved successfully");
	}
	
	public boolean saveMessageDetails(ContactInfo contact) {
		boolean issaved = true;
		log.info(contact.toString());
      System.out.println("\nfindAll()");
      contactrepository.findAll().forEach(x -> System.out.println(x.getEmail()));

		contactrepository.save(contact);  
		return issaved;
		
	}

}
