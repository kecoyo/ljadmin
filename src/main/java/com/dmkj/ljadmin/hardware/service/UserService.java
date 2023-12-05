package com.dmkj.ljadmin.hardware.service;

import java.util.List;

import com.dmkj.ljadmin.hardware.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.hardware.dao.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
}
