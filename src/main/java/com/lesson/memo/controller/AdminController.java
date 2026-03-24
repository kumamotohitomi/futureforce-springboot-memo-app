package com.lesson.memo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;

@Controller
public class AdminController {
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private AdminRepository adminRepository;

	    @PostMapping("/admin/signup")
	    public String registerAdmin(@ModelAttribute("admin") Admin admin) {

	        String encodedPassword = passwordEncoder.encode(admin.getPassword());
	        admin.setPassword(encodedPassword);

	        adminRepository.save(admin);
	        return "redirect:/admin/signin";
	    }
	    
	    @GetMapping("/admin/signup")
	    public String showSignup(Admin admin) {
	        return "admin/signup"; 
	    }
	    
	    @GetMapping("/admin/signin")
	    public String showSignin() {
	        return "admin/signin"; 
	    }
	}
