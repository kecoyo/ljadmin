package com.dmkj.ljadmin.hardware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.common.ResultCode;
import com.dmkj.ljadmin.common.exception.ApiException;
import com.dmkj.ljadmin.hardware.domain.User;
import com.dmkj.ljadmin.hardware.domain.UserAddBody;
import com.dmkj.ljadmin.hardware.domain.UserEditBody;
import com.dmkj.ljadmin.hardware.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BaseUserService baseUserService;

    public List<User> queryUserList() {
        return userMapper.queryUserList("", 3, 1, 20);
    }

    public User getUserInfo(int userid) {
        return userMapper.getUserInfo(userid);
    }

    public int addUser(UserAddBody userBody) throws Exception {
        int operator = 1000297;
        // 先查询基础用户信息
        User user = baseUserService.getUserInfoByPhone(userBody.getPhone());
        if (user == null) {
            // 基础用户信息不存在，需要先创建
            user = baseUserService.addUserInfo(userBody);
        }

        if (user == null) {
            throw new ApiException(ResultCode.FAIL.getCode(), "添加基础用户失败");
        }

        // 基础用户信息已经存在，直接添加用户
        int rowCnt = userMapper.addUser(user.getUserId(), userBody.getName(), userBody.getPhone(),
                userBody.getRole(), userBody.getAreaRange(), operator);

        if (rowCnt == 1) { // 成功，返回用户ID
            return user.getUserId();
        } else if (rowCnt == 2) {
            throw new ApiException(ResultCode.FAIL.getCode(), "参数错误");
        } else if (rowCnt == 3) {
            throw new ApiException(ResultCode.FAIL.getCode(), "用户已存在");
        } else if (rowCnt == 4) {
            throw new ApiException(ResultCode.FAIL.getCode(), "操作者不存在");
        } else if (rowCnt == 5) {
            throw new ApiException(ResultCode.FAIL.getCode(), "不能创建同级或上级用户");
        } else {
            throw new ApiException(ResultCode.FAIL.getCode(), "添加用户失败");
        }
    }

    public int updateUser(UserEditBody userBody) throws Exception {
        int operator = 1000297;
        int rowCnt = userMapper.updateUser(userBody.getUserId(), userBody.getRole(), userBody.getAreaRange(), operator);
        if (rowCnt == 1) { // 成功，返回用户ID
            return userBody.getUserId();
        } else if (rowCnt == 2) {
            throw new ApiException(ResultCode.FAIL.getCode(), "参数错误");
        } else if (rowCnt == 3) {
            throw new ApiException(ResultCode.FAIL.getCode(), "用户不存在");
        } else if (rowCnt == 4) {
            throw new ApiException(ResultCode.FAIL.getCode(), "操作者不存在");
        } else if (rowCnt == 5) {
            throw new ApiException(ResultCode.FAIL.getCode(), "不能修改同级或上级用户");
        } else {
            throw new ApiException(ResultCode.FAIL.getCode(), "修改用户失败");
        }
    }

    public int deleteUser(int userId) {
        int operator = 1000297;
        int rowCnt = userMapper.deleteUser(userId, operator);
        return rowCnt;
    }
}
