package com.minhtien.repository;

import com.minhtien.model.Login;
import com.minhtien.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
