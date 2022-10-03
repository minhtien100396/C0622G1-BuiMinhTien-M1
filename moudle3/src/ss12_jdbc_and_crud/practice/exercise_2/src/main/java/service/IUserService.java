package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    void add(User user);
    void edit (int id,User user);
    void delete (int id);
    User findById(int id);
}
