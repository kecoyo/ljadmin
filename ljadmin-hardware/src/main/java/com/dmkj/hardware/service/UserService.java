package com.dmkj.hardware.service;

import java.util.List;

import com.dmkj.hardware.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.hardware.dao.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
}
