package service.impl;

import model.User;
import repo.IUserRepo;
import repo.impl.UserRepo;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserRepo iUserRepo = new UserRepo();

    @Override
    public List<User> getAll() {
        return iUserRepo.getAll();
    }

    @Override
    public void add(User user) {
        iUserRepo.add(user);
    }

    @Override
    public void edit(int id, User user) {
        iUserRepo.edit(id,user);
    }

    @Override
    public void delete(int id) {
        iUserRepo.delete(id);
    }

    @Override
    public User findById(int id) {
        return iUserRepo.fintById(id);
    }
}
