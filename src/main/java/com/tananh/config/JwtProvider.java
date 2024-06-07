package com.tananh.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.tananh.modal.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtProvider {
	
	SecretKey secretKey = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
	public String genarateToken(Authentication authenticaiton) {
		String token = Jwts.builder()
						.setIssuedAt(new Date())
						.setExpiration(new Date(new Date().getTime()+86400000))
						.claim("email",authenticaiton.getName())
						.signWith(secretKey)
						.compact();
		return token;
						
	}
	public String genarateTokenFromUser(User user) {
		String token = Jwts.builder()
						.setIssuedAt(new Date())
						.setExpiration(new Date(new Date().getTime()+86400000))
						.claim("email",user.getEmail())
						.signWith(secretKey)
						.compact();
		return token;
						
	}
	public String getEmailFromToken(String jwt) {
		jwt=jwt.substring(7);
		Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody();
		String email= String.valueOf(claims.get("email"));
		return email;
	}
}
