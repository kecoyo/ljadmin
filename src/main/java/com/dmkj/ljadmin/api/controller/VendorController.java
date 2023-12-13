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

import com.dmkj.ljadmin.api.domain.Provider;
import com.dmkj.ljadmin.api.domain.dto.VendorAddDTO;
import com.dmkj.ljadmin.api.domain.dto.VendorQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.VendorUpdateDTO;
import com.dmkj.ljadmin.api.service.VendorService;
import com.dmkj.ljadmin.common.ResponseResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/vendor")
@Tag(name = "供应商管理")
public class VendorController {

    @Autowired
    private VendorService vendorServer;

    @Operation(summary = "获取供应商列表")
    @GetMapping(value = "/getVendorList")
    public ResponseResult<List<Provider>> getVendorList(VendorQueryDTO dto) {
        List<Provider> list = vendorServer.getVendorList(dto);
        return ResponseResult.success(list);
    }

    @Operation(summary = "获取供应商信息")
    @GetMapping(value = "/getVendorInfo")
    public ResponseResult<Provider> getVendorInfo(@RequestParam(value = "id") int id) {
        Provider info = vendorServer.getVendorInfo(id);
        return ResponseResult.success(info);
    }

    @Operation(summary = "添加供应商")
    @PostMapping(value = "/addVendor")
    public ResponseResult<Integer> addVendor(@Validated @RequestBody VendorAddDTO dto) {
        int insertId = vendorServer.addVendor(dto);
        return ResponseResult.success(insertId);
    }

    @Operation(summary = "修改供应商")
    @PostMapping(value = "/updateVendor")
    public ResponseResult<Integer> updateVendor(@Validated @RequestBody VendorUpdateDTO dto) {
        vendorServer.updateVendor(dto);
        return ResponseResult.success();
    }

    @Operation(summary = "删除供应商")
    @PostMapping(value = "/deleteVendor")
    public ResponseResult<Integer> deleteVendor(@RequestBody Set<Integer> ids) {
        vendorServer.deleteVendor(ids);
        return ResponseResult.success();
    }
}
