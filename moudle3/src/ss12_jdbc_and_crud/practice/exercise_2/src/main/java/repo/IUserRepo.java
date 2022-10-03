package repo;

import model.User;

import java.util.List;

public interface IUserRepo {
    List<User> getAll();
    void add(User user);
    void edit (int id,User user);
    void delete (int id);
    User fintById(int id);
}
