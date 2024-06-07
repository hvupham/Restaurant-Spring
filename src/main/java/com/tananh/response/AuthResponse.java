package com.tananh.response;

import com.tananh.dto.UserDto;

public class AuthResponse {
	private String jwt;
	private boolean message;
	private UserDto user;
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthResponse(String jwt, boolean message, UserDto user) {
		super();
		this.jwt = jwt;
		this.message = message;
		this.user = user;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public boolean isMessage() {
		return message;
	}
	public void setMessage(boolean message) {
		this.message = message;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
