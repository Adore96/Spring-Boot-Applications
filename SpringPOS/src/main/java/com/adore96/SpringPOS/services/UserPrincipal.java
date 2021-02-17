package com.adore96.SpringPOS.services;

import com.adore96.SpringJWT.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author kasun_k ON 12/22/20
 * @project SpringJWT
 */

public class UserPrincipal implements UserDetails {

    @Autowired
    private User user;

    public UserPrincipal(User User) {
        super();
        this.user = User;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        System.out.println("UserPrincipal Getpassword method --> " + user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("UserPrincipal Getusername method --> " + user.getUsername());
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
