package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "用户添加数据")
public class UserAddBody {

    @Schema(description = "姓名", example = "张三")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Schema(description = "手机号", example = "13800138000")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Schema(description = "角色,1-超级管理员，2-管理员，3-运维人员", example = "3")
    @NotNull(message = "角色不能为空")
    private Integer role;

    @Schema(description = "区域范围, 多个地域ID以逗号分隔", example = "1,2,3")
    @NotBlank(message = "区域范围不能为空")
    private String areaRange;

}
