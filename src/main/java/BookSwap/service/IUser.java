package BookSwap.service;

import BookSwap.model.entity.User;

import java.util.List;

public interface IUser {

    User save(User user);

    User findById(Integer id);

    void delete(User user);

    List<User> findAll();

    User findByEmail(String email);
}
