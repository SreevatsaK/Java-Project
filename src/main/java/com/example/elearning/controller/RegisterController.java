package com.example.elearning.controller;

import com.example.elearning.model.User;
import com.example.elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.elearning.utils.IdGenerator;


@Controller
public class RegisterController {

	@Autowired
	private IdGenerator idGenerator;

	@Autowired
	private UserRepository userRepo;

	@PostMapping("/signup")
	public String registerUser(@RequestParam String fullName,
	                           @RequestParam String emailID,
	                           @RequestParam String password,
	                           @RequestParam String role) {

	    // 1. Get last ID from DB
	    String lastId = userRepo.findLastUserId();

	    // 2. Set prefix based on role
	    String prefix;

	    switch(role.toLowerCase()) {
	        case "student": prefix = "US"; break;
	        case "instructor": prefix = "UI"; break;
	        case "admin": prefix = "AD"; break;
	        default: prefix = "US"; 
	    }

	    // 3. Create new ID
	    String newId = idGenerator.getNextId(lastId, prefix);

	    // 4. Create user object
	    User newUser = new User();
	    newUser.setUserId(newId);
	    newUser.setFullName(fullName);
	    newUser.setEmailID(emailID);
	    newUser.setPassword(password);
	    newUser.setRole(role);

	    // 5. Save to DB
	    userRepo.save(newUser);

	    return "redirect:/login.html";
	}


}
