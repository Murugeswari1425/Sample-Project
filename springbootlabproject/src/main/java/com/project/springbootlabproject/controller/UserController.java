package com.project.springbootlabproject.controller;

import com.project.springbootlabproject.entity.User;
import com.project.springbootlabproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping("/")
        public String home() {
            return "home";
        }

        @GetMapping("/search")
        public String search(Model model) {
            model.addAttribute("users", userService.getAllUsers());
            return "search";
        }

        @GetMapping("/detail/{id}")
        public String detail(@PathVariable Long id, Model model) {
            Optional<User> user = userService.getUserById(id);
            user.ifPresent(value -> model.addAttribute("user", value));
            return "detail";
        }

        @PostMapping("/save")
        public String save(@ModelAttribute User user) {
            userService.saveUser(user);
            return "redirect:/search";
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable Long id) {
            userService.deleteUser(id);
            return "redirect:/search";}

    }
