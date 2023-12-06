package com.dmkj.ljadmin.hardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.hardware.domain.User;
import com.dmkj.ljadmin.hardware.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUserList() {
        return userMapper.queryUserList("", 3, 1, 20);
    }

    public User getUserInfo(int userid) {
        return userMapper.getUserInfo(userid);
    }

    public int addUser(User user) {
        int rowCnt = userMapper.addUser(user.getUserId(), user.getName(), user.getPhone(),
                user.getRole(), user.getAreaRange(), 1000297);
        return rowCnt;
    }
}
