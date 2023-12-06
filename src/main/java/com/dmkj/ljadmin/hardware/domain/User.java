package com.dmkj.ljadmin.hardware.domain;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "用户信息")
public class User {
    @Schema(description = "用户ID")
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @Schema(description = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Schema(description = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Schema(description = "角色,1-超级管理员，2-管理员，3-运维人员")
    @NotNull(message = "角色不能为空")
    private Integer role;

    @Schema(description = "区域范围, 多个地域ID以逗号分隔")
    @NotBlank(message = "区域范围不能为空")
    private String areaRange;

    @Schema(description = "状态, 0-正常，1-停用")
    private Integer status;

    @Schema(description = "修改时间")
    private Date updatedTime;
}
