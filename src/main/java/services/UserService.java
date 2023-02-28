package services;

import domain.User;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers() throws Exception;
}
