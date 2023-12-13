package com.dmkj.ljadmin.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmkj.ljadmin.api.domain.Device;
import com.dmkj.ljadmin.api.domain.dto.DeviceAddDTO;
import com.dmkj.ljadmin.api.domain.dto.DeviceQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.DeviceUpdateDTO;
import com.dmkj.ljadmin.api.service.DeviceService;
import com.dmkj.ljadmin.common.ResponseResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/device")
@Tag(name = "设备管理")
public class DeviceController {

    @Autowired
    private DeviceService deviceServer;

    @Operation(summary = "获取设备列表")
    @GetMapping(value = "/getDeviceList")
    public ResponseResult<List<Device>> getDeviceList(DeviceQueryDTO dto) {
        List<Device> list = deviceServer.getDeviceList(dto);
        return ResponseResult.success(list);
    }

    @Operation(summary = "获取设备信息")
    @GetMapping(value = "/getDeviceInfo")
    public ResponseResult<Device> getDeviceInfo(@RequestParam(value = "id") int id) {
        Device info = deviceServer.getDeviceInfo(id);
        return ResponseResult.success(info);
    }

    @Operation(summary = "添加设备")
    @PostMapping(value = "/addDevice")
    public ResponseResult<Integer> addDevice(@Validated @RequestBody DeviceAddDTO dto) {
        int insertId = deviceServer.addDevice(dto);
        return ResponseResult.success(insertId);
    }

    @Operation(summary = "修改设备")
    @PostMapping(value = "/updateDevice")
    public ResponseResult<Integer> updateDevice(@Validated @RequestBody DeviceUpdateDTO dto) {
        deviceServer.updateDevice(dto);
        return ResponseResult.success();
    }

    @Operation(summary = "删除设备")
    @PostMapping(value = "/deleteDevice")
    public ResponseResult<Integer> deleteDevice(@RequestBody Set<Integer> ids) {
        deviceServer.deleteDevice(ids);
        return ResponseResult.success();
    }
}
