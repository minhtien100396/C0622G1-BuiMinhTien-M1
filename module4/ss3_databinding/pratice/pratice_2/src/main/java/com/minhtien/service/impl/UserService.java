package com.minhtien.service.impl;

import com.minhtien.model.Login;
import com.minhtien.model.User;
import com.minhtien.repository.IUserRepository;
import com.minhtien.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
