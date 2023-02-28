package com.example.projecthibernatejpa_springboot.services;

import com.example.projecthibernatejpa_springboot.domain.User;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers() throws Exception;
}
