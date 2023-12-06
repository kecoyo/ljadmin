package com.dmkj.ljadmin.hardware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmkj.ljadmin.common.ResponseResult;
import com.dmkj.ljadmin.hardware.domain.User;
import com.dmkj.ljadmin.hardware.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hardware/user")
@Tag(name = "用户接口")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @Operation(summary = "获取用户信息", description = "", security = { @SecurityRequirement(name = "bearer-key") })
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @Operation(summary = "获取用户列表", description = "")
    public ResponseResult<List<User>> findAll() {
        List<User> list = userService.queryUserList();
        return ResponseResult.success(list);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @Operation(summary = "获取用户列表", description = "")
    public ResponseResult<User> getUserInfo(@RequestParam(value = "userid") int userid) {
        User user = userService.getUserInfo(userid);
        return ResponseResult.success(user);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @Operation(summary = "新增用户")
    public ResponseResult<Integer> addUser(@Valid @RequestBody User user) {
        log.info("[createUser][body: {}]", user);
        int rowCnt = userService.addUser(user);
        return ResponseResult.success(rowCnt);
    }

}
