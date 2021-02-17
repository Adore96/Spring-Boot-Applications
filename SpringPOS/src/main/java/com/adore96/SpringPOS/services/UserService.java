package com.adore96.SpringPOS.services;

import com.adore96.SpringPOS.bean.UserDatabean;
import com.adore96.SpringPOS.model.User;
import com.adore96.SpringPOS.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author kasun_k ON 1/25/21
 * @project SpringJWT
 */

@Configuration
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void signUp(UserDatabean userDatabean) {
        User user = new User();

        user.setFname(userDatabean.getFname());
        user.setLname(userDatabean.getLname());
        user.setUsername(userDatabean.getUsername());
        user.setUsername(userDatabean.getUsername());
        user.setPassword(userDatabean.getPassword());
        user.setTelephone(userDatabean.getTelephone());
        user.setRoleid(userDatabean.getRoleid());

        userRepo.save(user);
    }

    public void deleteUser(UserDatabean userDatabean){

    }
}