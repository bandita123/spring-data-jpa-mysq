package com.mkyong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public1")
public class EmployeeController {
	@RequestMapping("/register1")
	public String display_register_page(Model model) {
	//	model.addAttribute("person",new Person());
		return "employee_register1.html";
	}
}
