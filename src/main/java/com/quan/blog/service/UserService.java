package com.quan.blog.service;


import com.quan.blog.entity.User;

public interface UserService {

    User checkUser(String username, String password);
}
