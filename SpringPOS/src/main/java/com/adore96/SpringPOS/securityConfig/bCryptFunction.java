package com.adore96.SpringPOS.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringPOS
 */

@Service
public class bCryptFunction {

    @Bean
    public PasswordEncoder encoder(){
        System.out.println("password bcrypted.");
        return new BCryptPasswordEncoder();
    }
}
