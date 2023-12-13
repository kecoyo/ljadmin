package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "查询供应商的参数")
public class ProviderQueryDTO {

    @Schema(description = "供应商IDs", example = "1,2,3")
    private String ids = "";

    @Schema(description = "供应商名称", example = "华为")
    private String name = "";

    @Schema(description = "所在地域", example = "1")
    private Integer areaId = 0;

    @Schema(description = "供应商联系人", example = "张三")
    private String liaison = "";

    @Schema(description = "供应商手机号", example = "13800138000")
    private String phone = "";
}
