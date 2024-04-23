package com.axcore.portal.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "auth-login";
		}
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String handleLogoutRequest(HttpServletRequest requests) {
		
		requests.getSession().invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/home")
	public String loginSubmit() {
		return "pages/main";
	}

}
