package com.lesson.memo.repository;

import java.util.Optional;

import com.lesson.memo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
　　Optional<Admin> findByEmail(String email);
}

