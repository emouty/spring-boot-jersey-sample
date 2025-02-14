package com.example.demo;

import java.util.Date;


public class UserMapper {

    public String getUser(int id) {
        // Logic to retrieve user by id
        return id + " - John Doe " + new Date();
    }
}
