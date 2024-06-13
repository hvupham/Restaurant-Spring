package com.tananh.service;

import com.tananh.exception.UserException;
import com.tananh.modal.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUser() throws UserException;
}
