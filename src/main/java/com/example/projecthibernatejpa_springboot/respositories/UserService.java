package com.example.projecthibernatejpa_springboot.respositories;

import com.example.projecthibernatejpa_springboot.Exceptions.UserException;
import com.example.projecthibernatejpa_springboot.domain.User;

import java.util.List;

public interface UserService {
    void create(User object) throws UserException;

    void delete(User object) throws UserException;

    List<User> getAll() throws UserException;

    User getById(int id) throws UserException;

    void update(User object) throws UserException;

}
