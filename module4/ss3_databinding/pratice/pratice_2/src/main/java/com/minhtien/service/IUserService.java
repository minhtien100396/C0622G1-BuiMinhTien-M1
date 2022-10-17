package com.minhtien.service;

import com.minhtien.model.Login;
import com.minhtien.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
