package resources;

import domain.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {
    //private UserService userDAO;
    @Autowired
    private UserService userService;


    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(HttpServletRequest request) {
        System.out.println(1);
        List<User> users = null;
        try {
            //users = userDAO.fetchAllUsers();
            users = userService.fetchAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
