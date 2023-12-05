package com.dmkj.ljadmin.business.controller;

import com.dmkj.ljadmin.business.model.SchoolInfo;
import com.dmkj.ljadmin.business.service.SchoolService;

// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiParam;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/business/school")
// @Api(tags = "学校接口")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/getSchoolList", method = RequestMethod.GET)
    // @ApiOperation(value = "获取学校列表")
    public ResponseEntity<List<SchoolInfo>> getSchoolList() {
        List<SchoolInfo> list = schoolService.getSchoolList();
        return new ResponseEntity<List<SchoolInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/getSchoolInfo", method = RequestMethod.GET)
    // @ApiOperation(value = "获取学校信息")
    // @ApiResponses({
    // @ApiResponse(code = 200, message = "请求成功", response = SchoolInfo.class),
    // @ApiResponse(code = 404, message = "用户不存在")
    // })
    public ResponseEntity<SchoolInfo> getSchoolInfo(@RequestParam("id") Integer id) {
        SchoolInfo schoolInfo = schoolService.getSchoolInfo(id);
        return new ResponseEntity<>(schoolInfo, HttpStatus.OK);
    }

}
