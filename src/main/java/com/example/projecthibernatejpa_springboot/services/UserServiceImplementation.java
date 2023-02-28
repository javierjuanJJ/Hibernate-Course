package com.example.projecthibernatejpa_springboot.services;

import com.example.projecthibernatejpa_springboot.domain.User;
import com.example.projecthibernatejpa_springboot.respositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDAO userRepository;

    public List<User> fetchAllUsers() throws Exception {
        return userRepository.getAll();
    }

}
