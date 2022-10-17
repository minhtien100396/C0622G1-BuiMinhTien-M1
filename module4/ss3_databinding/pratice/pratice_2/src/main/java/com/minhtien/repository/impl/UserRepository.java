package com.minhtien.repository.impl;

import com.minhtien.model.Login;
import com.minhtien.model.User;
import com.minhtien.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements IUserRepository {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("john","123456","John","john@codegym.vn",10));
        users.add(new User("mike","123456","Mike","mike@codegym.vn",10));
        users.add(new User("bill","123456","Bill","bill@codegym.vn",15));
    }

    @Override
    public User checkLogin(Login login) {
        for (User user:users) {
            if (user.getAccount().equals(login.getAccount())&&user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }
}
