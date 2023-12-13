package com.dmkj.ljadmin.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmkj.ljadmin.api.domain.Provider;
import com.dmkj.ljadmin.api.domain.dto.ProviderAddDTO;
import com.dmkj.ljadmin.api.domain.dto.ProviderQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.ProviderUpdateDTO;
import com.dmkj.ljadmin.api.domain.dto.ProviderAddDTO.Create;
import com.dmkj.ljadmin.api.service.ProviderService;
import com.dmkj.ljadmin.common.ResponseResult;
import com.dmkj.ljadmin.common.exception.BadRequestException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/provider")
@Tag(name = "供应商管理")
public class ProviderController {

    @Autowired
    private ProviderService providerServer;

    @Operation(summary = "获取供应商列表")
    @GetMapping(value = "/getProviderList")
    public ResponseResult<List<Provider>> getProviderList(ProviderQueryDTO dto) {
        List<Provider> list = providerServer.getProviderList(dto);
        return ResponseResult.success(list);
    }

    @Operation(summary = "获取供应商信息")
    @GetMapping(value = "/getProviderInfo")
    public ResponseResult<Provider> getProviderInfo(@RequestParam(value = "id") @PathVariable(value = "id") int id) {
        Provider info = providerServer.getProviderInfo(id);
        return ResponseResult.success(info);
    }

    @Operation(summary = "添加供应商")
    @PostMapping(value = "/addProvider")
    public ResponseResult<Integer> addProvider(@Validated @RequestBody ProviderAddDTO dto) {
        log.info("[addProvider][dto: {}]", dto);
        int insertId = providerServer.addProvider(dto);
        return ResponseResult.success(insertId);
    }

    @Operation(summary = "修改供应商")
    @PostMapping(value = "/updateProvider")
    public ResponseResult<Integer> updateProvider(@Validated @RequestBody ProviderUpdateDTO dto) {
        log.info("[updateProvider][dto: {}]", dto);
        providerServer.updateProvider(dto);
        return ResponseResult.success();
    }

    @Operation(summary = "删除供应商")
    @PostMapping(value = "/deleteProvider")
    public ResponseResult<Integer> deleteProvider(@RequestBody Set<Integer> ids) {
        log.info("[deleteProvider][ids: {}]", ids);
        providerServer.deleteProvider(ids);
        return ResponseResult.success();
    }
}
