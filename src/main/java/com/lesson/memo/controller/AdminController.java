import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;

package com.lesson.memo.controller;

@Controller
public class AdminController {
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private AdminRepository adminRepository;

	    @PostMapping("/admin/signup")
	    public String register(Admin admin) {

	        String encodedPassword = passwordEncoder.encode(admin.getPassword());
	        admin.setPassword(encodedPassword);

	        adminRepository.save(admin);
	        return "redirect:/admin/signin";
	    }
	}

}
