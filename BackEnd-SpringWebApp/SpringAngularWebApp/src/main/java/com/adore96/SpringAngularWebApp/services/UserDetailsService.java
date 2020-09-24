package com.adore96.SpringAngularWebApp.services;

import com.adore96.SpringAngularWebApp.dao.StudentRepo;
import com.adore96.SpringAngularWebApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = studentRepo.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return users.map(UserPrincipal::new).get();
    }
}
