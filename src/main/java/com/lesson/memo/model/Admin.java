package com.lesson.memo.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

package com.lesson.memo.controller;

package com.lesson.memo.model;

@Entity
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(nullable = false, length = 255)
    private String last_name;
    
    @Column(nullable = false, length = 255)
    private String first_name;
    
    @Column(nullable = false, length = 255, unique = true)
    private String email; 
    
    @Column(nullable = false, length = 255)
    private String password; 

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}

