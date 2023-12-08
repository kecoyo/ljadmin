package com.dmkj.ljadmin.business.controller;

import com.dmkj.ljadmin.business.domain.SchoolInfo;
import com.dmkj.ljadmin.business.service.SchoolService;
import com.dmkj.ljadmin.common.ResponseResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business/school")
@Tag(name = "学校接口")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/getSchoolList", method = RequestMethod.GET)
    @Operation(summary = "获取学校列表")
    public ResponseResult<List<SchoolInfo>> getSchoolList() {
        List<SchoolInfo> list = schoolService.getSchoolList();
        return ResponseResult.success(list);
    }

    @RequestMapping(value = "/getSchoolInfo", method = RequestMethod.GET)
    @Operation(summary = "获取学校信息")
    public ResponseResult<SchoolInfo> getSchoolInfo(
            @Validated @RequestParam("id") @Min(value = 1L, message = "学校ID必须大于0") Integer id) {
        SchoolInfo schoolInfo = schoolService.getSchoolInfo(id);
        return ResponseResult.success(schoolInfo);
    }

}
