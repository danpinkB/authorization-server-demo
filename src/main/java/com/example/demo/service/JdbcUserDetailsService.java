package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JdbcUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Bean
    public void bla(){
        System.out.println(userService.getUserByUsername("test"));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(userService.getUserByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found")));
    }
}