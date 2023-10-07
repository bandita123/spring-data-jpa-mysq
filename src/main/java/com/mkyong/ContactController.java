package com.mkyong;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
	private ContactService contactservice = new ContactService();
	private static Logger log = LoggerFactory.getLogger(ContactService.class);

	@Autowired
	public ContactController(ContactService contactservice) {
		this.contactservice = contactservice;
		
	}
	@RequestMapping("/home_test")
	public String displayHomePage_t(Model model) {
		model.addAttribute("username","Bandita");
		return "home.html";
	}
	@RequestMapping("/contact")
	public String displayHomePage(Model model) {
		model.addAttribute("contact",new ContactInfo());
		return "contact_test1.html";
	}
	@RequestMapping(value="/saveMsg", method=RequestMethod.POST)
	public String save_contact_msg(@ModelAttribute ContactInfo contact,Errors error) {
		System.out.println("In savemsg method");
		if(error.hasErrors()) {
			System.out.println("Contact page has errors full");
			return "contact.html";
		}
		contactservice.setCounter(contactservice.getCounter()+1);
		contactservice.saveMessageDetails(contact);
		
		log.info("Number of times form submitted:::"+contactservice.getCounter());
		return "redirect:/contact";
	}
}
