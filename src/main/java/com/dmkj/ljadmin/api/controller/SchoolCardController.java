package com.dmkj.ljadmin.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmkj.ljadmin.api.domain.SchoolCard;
import com.dmkj.ljadmin.api.domain.dto.SchoolCardQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.SchoolCardSaveDTO;
import com.dmkj.ljadmin.api.service.SchoolCardService;
import com.dmkj.ljadmin.common.ResponseResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/schoolCard")
@Tag(name = "学校班牌配置管理")
public class SchoolCardController {

    @Autowired
    private SchoolCardService schoolCardServer;

    @Operation(summary = "获取学校班牌配置列表")
    @GetMapping(value = "/getSchoolCardList")
    public ResponseResult<List<SchoolCard>> getSchoolCardList(SchoolCardQueryDTO dto) {
        List<SchoolCard> list = schoolCardServer.getSchoolCardList(dto);
        return ResponseResult.success(list);
    }

    @Operation(summary = "保存学校班牌配置")
    @PostMapping(value = "/saveSchoolCard")
    public ResponseResult<Integer> saveSchoolCard(@Validated @RequestBody SchoolCardSaveDTO dto) {
        schoolCardServer.saveSchoolCard(dto);
        return ResponseResult.success();
    }

    @Operation(summary = "删除学校班牌配置")
    @PostMapping(value = "/deleteSchoolCard")
    public ResponseResult<Integer> deleteSchoolCard(@RequestBody Set<Integer> ids) {
        schoolCardServer.deleteSchoolCard(ids);
        return ResponseResult.success();
    }
}
