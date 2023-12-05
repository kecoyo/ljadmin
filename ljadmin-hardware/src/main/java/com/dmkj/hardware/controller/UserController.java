package com.dmkj.hardware.controller;

import java.util.List;

import com.dmkj.hardware.model.User;
import com.dmkj.hardware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/hardware/user")
@Tag(name = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @Operation(summary = "获取用户信息", description = "")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @Operation(summary = "获取用户列表", description = "")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

}
