package com.adore96.SpringBootCRUD.resource;

import com.adore96.SpringBootCRUD.model.Users;
import com.adore96.SpringBootCRUD.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/")
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    @PostMapping("/load")
    public List<Users> persist(@RequestBody final Users users) {
        userRepo.save(users);
        return userRepo.findAll();
    }
}
