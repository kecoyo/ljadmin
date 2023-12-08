package com.dmkj.ljadmin.hardware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmkj.ljadmin.common.ResponseResult;
import com.dmkj.ljadmin.common.ResultCode;
import com.dmkj.ljadmin.common.exception.ApiException;
import com.dmkj.ljadmin.hardware.domain.User;
import com.dmkj.ljadmin.hardware.domain.UserAddBody;
import com.dmkj.ljadmin.hardware.domain.UserEditBody;
import com.dmkj.ljadmin.hardware.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hardware/user")
@Tag(name = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "查询用户列表")
    @PreAuthorize("@el.check('user:list')")
    @GetMapping(value = "/queryUserList")
    public ResponseResult<List<User>> queryUserList() {
        List<User> list = userService.queryUserList();
        return ResponseResult.success(list);
    }

    @Operation(summary = "获取用户信息")
    @GetMapping(value = "/{userId}")
    public ResponseResult<User> getUserInfo(@Parameter @PathVariable(value = "userId") int userId) {
        User user = userService.getUserInfo(userId);
        if (user == null) {
            return ResponseResult.fail(ResultCode.NOT_FOUND.getCode(), "用户不存在");
        }
        return ResponseResult.success(user);
    }

    @Operation(summary = "新增用户")
    // @PreAuthorize("@el.check('user:add')")
    @PostMapping(value = "/addUser")
    public ResponseResult<Integer> addUser(@Validated @RequestBody UserAddBody userBody) throws Exception {
        log.info("[addUser][user: {}]", userBody);
        int userId = userService.addUser(userBody);
        return ResponseResult.success(userId);
    }

    @Operation(summary = "修改用户")
    @PreAuthorize("@el.check('user:edit')")
    @PostMapping(value = "/updateUser")
    public ResponseResult<Integer> updateUser(@Validated @RequestBody UserEditBody userBody) throws Exception {
        log.info("[updateUser][user: {}]", userBody);
        int rowCnt = userService.updateUser(userBody);
        return ResponseResult.success(rowCnt);
    }

    @Operation(summary = "删除用户")
    // @PreAuthorize("@el.check('user:del')")
    @GetMapping(value = "/deleteUser/{userId}")
    public ResponseResult<Integer> deleteUser(@Parameter @PathVariable(value = "userId") int userId) {
        log.info("[deleteUser][userId: {}]", userId);
        int rowCnt = userService.deleteUser(userId);
        return ResponseResult.success(rowCnt);
    }
}
