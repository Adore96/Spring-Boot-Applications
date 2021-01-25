//package com.adore96.SpringJWT.services;
//
//import com.adore96.SpringJWT.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
///**
// * @author kasun_k ON 12/22/20
// * @project SpringJWT
// */
//
//public class UserPrincipal implements UserDetails {
//
//    @Autowired
//    private User User;
//
//    public UserPrincipal(User User) {
//        super();
//        this.User = User;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        System.out.println("UserPrincipal Getpassword method --> " + User.getPassword());
//        return User.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
