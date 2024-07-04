package com.project.springbootlabproject.repository;

import com.project.springbootlabproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
