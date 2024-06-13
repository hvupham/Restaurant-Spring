package com.tananh.service;

import com.tananh.exception.UserException;
import com.tananh.modal.User;
import com.tananh.respository.UserResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserResponsitory userResponsitory;

    @Override
    public List<User> getAllUser() throws UserException {
        List<User> users = userResponsitory.findAll();
        return users;
    }

}
