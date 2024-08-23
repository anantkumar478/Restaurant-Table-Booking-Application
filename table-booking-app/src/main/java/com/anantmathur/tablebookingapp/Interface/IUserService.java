package com.anantmathur.tablebookingapp.Interface;
import com.anantmathur.tablebookingapp.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User addUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
