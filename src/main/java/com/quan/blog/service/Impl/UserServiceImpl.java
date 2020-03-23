package com.quan.blog.service.Impl;


import com.quan.blog.dao.UserDao;
import com.quan.blog.entity.User;
import com.quan.blog.service.UserService;
import com.quan.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
