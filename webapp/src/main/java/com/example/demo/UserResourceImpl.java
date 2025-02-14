package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class UserResourceImpl implements UserResource {

    UserMapper userMapper;

    public UserResourceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String getUser(int id) {
        return userMapper.getUser(id);
    }
}
