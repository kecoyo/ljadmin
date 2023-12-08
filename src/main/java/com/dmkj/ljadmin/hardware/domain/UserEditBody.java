package com.dmkj.ljadmin.hardware.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "用户修改数据")
public class UserEditBody {
    @Schema(description = "用户ID", example = "1")
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @Schema(description = "角色,1-超级管理员，2-管理员，3-运维人员", example = "3")
    @NotNull(message = "角色不能为空")
    private Integer role;

    @Schema(description = "区域范围, 多个地域ID以逗号分隔", example = "1,2,3")
    @NotBlank(message = "区域范围不能为空")
    private String areaRange;

}
