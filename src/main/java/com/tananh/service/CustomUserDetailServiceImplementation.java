package com.tananh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tananh.modal.User;
import com.tananh.respository.UserResponsitory;

@Service
public class CustomUserDetailServiceImplementation implements UserDetailsService{
	@Autowired UserResponsitory userResponsitory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("JWT token: " );
		User user =userResponsitory.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("tài khoản đăng nhập không đúng: "+username);
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getMatKhau(),authorities);
	}
}
