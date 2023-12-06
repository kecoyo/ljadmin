package com.dmkj.ljadmin.hardware.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmkj.ljadmin.hardware.domain.User;
import com.dmkj.ljadmin.hardware.mapper.UserMapper;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void queryUserList() {
        List<User> list = userMapper.queryUserList("", 3, 1, 20);
        System.out.println(list);
        assert list.size() > 0;
    }

    @Test
    void getUserInfo() {
        User user = userMapper.getUserInfo(1000102);
        System.out.println(user);
        assert user != null;
    }

    @Test
    void addUser() {
        int rowCnt = userMapper.addUser(1000106, "test", "12345678901", 3, "32,384,3407", 1000297);
        System.out.println(rowCnt);
        assert rowCnt == 1; // rowCnt：0失败 1成功 2参数错误 3用户已存在 4操作者不存在 5不能创建同级或上级用户
    }

    @Test
    void updateUser() {
        int rowCnt = userMapper.updateUser(1000106, 3, "32,384,3407", 1000297);
        System.out.println(rowCnt);
        assert rowCnt == 1; // rowCnt：0失败 1成功 2参数错误 3用户不存在 4操作者不存在 5不能修改同级或上级用户
    }

    @Test
    void deleteUser() {
        int rowCnt = userMapper.deleteUser(1000106, 1000297);
        System.out.println(rowCnt);
        assert rowCnt == 1; // rowCnt：0失败 1成功 2参数错误 3用户不存在 4操作者不存在 5不能修改同级或上级用户
    }

}
