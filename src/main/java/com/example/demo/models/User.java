package com.example.demo.models;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class User {
    private String username;
    private String password;
    private String role;
    public static class RowWrapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User auxMenu = new User();
            auxMenu.setUsername(rs.getString("username"));
            auxMenu.setPassword(rs.getString("password"));
            auxMenu.setRole(rs.getString("role"));
            return auxMenu;
        }
    }
}
