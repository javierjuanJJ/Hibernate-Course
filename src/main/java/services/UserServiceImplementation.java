package services;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import respositories.GenericDAO;

import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    GenericDAO<User> userRepository;

    public List<User> fetchAllUsers() throws Exception {
        return userRepository.getAll();
    }

}
