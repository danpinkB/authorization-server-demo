package com.example.demo.service;

import com.example.demo.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    public Optional<User> getUserByUsername(String username){
        return Optional.of(jdbcTemplate.queryForObject("select * from users where username=?", new User.RowWrapper(), username));
    }
}
