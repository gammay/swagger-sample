package com.gammay.example.swagger_sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/contact")
public class ContactController {

	static private List<ContactDTO> contacts;
	
	static {
		contacts = new ArrayList<ContactDTO>();
		
		ContactDTO c1 = new ContactDTO();
		c1.setId(1);
		c1.setName("John");
		c1.setContactType("MOBILE");
		c1.setContactText("9012345678");
		contacts.add(c1);
		
		ContactDTO c2 = new ContactDTO();
		c2.setId(2);
		c2.setName("Pierre");
		c2.setContactType("EMAIL");
		c2.setContactText("peirre@mymail.com");
		contacts.add(c2);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ContactDTO> getContacts() {		
		return contacts;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ContactDTO createContact(HttpServletResponse response,
			@RequestBody(required=true) ContactDTO c) throws Exception {
		
		if(c.getName() == null || c.getName().length() == 0) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Contact name is required");
			return null;
		}
		if(c.getContactType() == null || c.getContactType().length() == 0) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Contact type is required");
			return null;
		}
		if(c.getContactText() == null || c.getContactText().length() == 0) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Contact text is required");
			return null;
		}
		
		// Assign a random id
		c.setId(new Random().nextInt(100));
		
		contacts.add(c);
		
		return c;
	}
}
