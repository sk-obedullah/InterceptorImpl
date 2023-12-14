package com.InterceptorImpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InterceptorImpl.service.AuthService;

@RestController
@RequestMapping("/api")
public class DemoController {

	AuthService authService;

	@PostMapping("/test")
	public String testControllerMethod(@RequestHeader("userId") String userId) {
		System.out.println("/api/test :: Handler execution Strted user Id -> " + userId + "...");
		return "/api/test :: Handler executed for user Id -> " + userId;
	}
}
