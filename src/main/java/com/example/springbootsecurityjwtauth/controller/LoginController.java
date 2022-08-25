package com.example.springbootsecurityjwtauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {

	@GetMapping("/")
	public String homePage() {
		return "Home page.";
	}

	/**
	 * Enable annotation (ex: @PreAuthorize) to protect method Access authentication
	 * object Spring auto inject Authenticated user from SecurityContext
	 */
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String userPage(Authentication authentication) {
		log.info("Username={}, roles={}", authentication.getPrincipal(), authentication.getAuthorities());
		return "User page.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminPage(Authentication authentication) {
		log.info("Username={}, roles={}", authentication.getPrincipal(), authentication.getAuthorities());
		return "Admin page";
	}
}
