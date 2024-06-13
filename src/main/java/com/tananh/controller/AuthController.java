package com.tananh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tananh.config.JwtProvider;
import com.tananh.dto.UserDto;
import com.tananh.exception.UserException;
import com.tananh.modal.KhachHang;
import com.tananh.modal.User;
import com.tananh.request.LoginRequest;
import com.tananh.request.RegisterRequest;
import com.tananh.response.AuthResponse;
import com.tananh.respository.KhachHangRespository;
import com.tananh.respository.UserResponsitory;
import com.tananh.service.CustomUserDetailServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired CustomUserDetailServiceImplementation customUserDetailServiceImplementation;
    @Autowired UserResponsitory userResponsitory;
    @Autowired JwtProvider jwtProvider;
    @Autowired KhachHangRespository khachHangRespository;
    @Autowired PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> createHanderUser(@RequestBody RegisterRequest user) throws UserException {
       
        String email = user.getEmail();
        String password = user.getPassword();
        String username = user.getName();

        if (userResponsitory.findByEmail(email) != null) {
            throw new UserException("Email đã được sử dụng");
        }

        User createUser = new User();
        createUser.setEmail(email);
        createUser.setMatKhau(password);
        createUser.setTrangThai("Verified");
        createUser.setVaiTro("admin");
        createUser.setUsername(username);
        User UserSaved = userResponsitory.save(createUser);
        
        KhachHang kh = new KhachHang();
        kh.setTenKh(username);
        kh.setIdNd(UserSaved.getId());
        khachHangRespository.save(kh);

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.genarateToken(authentication);

        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setMatkhau(password);
        userDto.setUsername(username);
        userDto.setVaitro(UserSaved.getVaiTro());

        AuthResponse authRes = new AuthResponse(token, true, userDto);

        return new ResponseEntity<>(authRes, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginHander(@RequestBody LoginRequest user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassword();
        User UserFinded = userResponsitory.findByEmail(email);
        Authentication authentication = authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.genarateToken(authentication);

        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setMatkhau(password);
        userDto.setUsername(UserFinded.getUsername());
        userDto.setVaitro(UserFinded.getVaiTro());
        AuthResponse authRes = new AuthResponse(token, true, userDto);

        return new ResponseEntity<>(authRes, HttpStatus.OK);
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = customUserDetailServiceImplementation.loadUserByUsername(email);
        if (userDetails == null || !password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Tài khoản không đúng hoặc không chính xác!");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
