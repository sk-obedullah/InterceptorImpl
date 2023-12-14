package com.InterceptorImpl.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

	public boolean checkingAuth(String userId) {
		System.out.println("AuthService :: chekingAuth() -> checking Authrization of user : " + userId);
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("AuthService :: chekingAuth() ->  user Authorized: " + userId);
		return false;
	}
}
