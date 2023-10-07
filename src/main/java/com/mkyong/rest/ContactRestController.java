package com.mkyong.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkyong.ContactInfo;
import com.mkyong.ContactRepository;

//@Controller
@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping(path="/api/contact",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public class ContactRestController {
	
	@Autowired
	private ContactRepository contactrepository;
	
	@GetMapping("/getContacts")
	//@ResponseBody
	public List<ContactInfo> getContactsBy(@RequestParam(name="username") String username){
		System.out.println(contactrepository.findByUsername(username));
		 return (List<ContactInfo>) contactrepository.findByUsername(username);
	}
	@GetMapping("/getContactsbybody")
	//@ResponseBody
	public List<ContactInfo> getContactsBy_all(@RequestBody ContactInfo contact){
		System.out.println(contactrepository.findByUsername(contact.getUsername()));
		 return (List<ContactInfo>) contactrepository.findByUsername(contact.getUsername());
	}
	
	@PostMapping("/saveMsg_details")
	//@ResponseBody
	public ResponseEntity<Response> save_msg_details(@RequestHeader("invocationFrom") String invocationFrom,@RequestBody ContactInfo contact){
		System.out.println("Invocation from is:::"+invocationFrom);
		contactrepository.save(contact);
		Response response = new Response();
		response.setStatuscode("200");
		response.setStatusMsg("Contact saved successfully");
		
		return ResponseEntity
				.status(HttpStatus.OK)
				//.header("ismsgsaved", true)
				.body(response);
				
	}
	@Transactional
	@DeleteMapping("/delete_msg_username")
	public ResponseEntity<Response> deleteByusername(RequestEntity<ContactInfo> contact){
		ContactInfo contact_obj = contact.getBody();
		contactrepository.deleteByUsername(contact_obj.getUsername());
		Response response = new Response();
		response.setStatuscode("200");
		response.setStatusMsg("Contact deleted successfully");
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
				
	}
	
	@PatchMapping("/closeMsg")
	public ResponseEntity<Response> update_msg_details(@RequestBody ContactInfo contact){
		Response response = new Response();
		Optional<ContactInfo> contact_opt = contactrepository.findByMobno(contact.getMobno());
		if(contact_opt.isPresent()) {
			contact_opt.get().setEmail(contact.getEmail());
			contactrepository.save(contact_opt.get());
		}else {
			response.setStatuscode("400");
			response.setStatusMsg("Invalid contact id");
			return ResponseEntity
				   .status(HttpStatus.OK)
				   .body(response);
		}
		response.setStatuscode("200");
		response.setStatusMsg("Contact details updated successfully");
		return ResponseEntity
			   .status(HttpStatus.OK)
			   .body(response);
		
	}

}
