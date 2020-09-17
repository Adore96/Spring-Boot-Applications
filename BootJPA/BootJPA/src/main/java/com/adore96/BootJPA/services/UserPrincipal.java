package com.adore96.BootJPA.services;

import com.adore96.BootJPA.model.Roledetails;
import com.adore96.BootJPA.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    @Autowired
    Roledetails roledetails;

    private Users users;

    public UserPrincipal(Users users) {
        super();
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        Roledetails role = users.getRoleid();
        System.out.println("UserPrincipal Class -> users.getRoleid() -> " + role);
        authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        return authorities;
    }

    @Override
    public String getPassword() {
        System.out.println("UserPrincipal Getpassword method --> " + users.getPassword());
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("UserPrincipal Getusername method --> " + users.getUsername());
        return users.getUsername();
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
