package com.example.demo.provider;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public class MyAuthenticationProvider implements AuthenticationProvider, Serializable {
    private final UserService userService;

    public MyAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userService.getUserByUsername(authentication.getName()).orElse(null);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAaa");
        System.out.println(authentication.getCredentials());
        if (user.getPassword().equals(authentication.getCredentials().toString())){
            return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials());
        }
        throw new BadCredentialsException("Username/Password does not match for " + authentication.getPrincipal());
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}