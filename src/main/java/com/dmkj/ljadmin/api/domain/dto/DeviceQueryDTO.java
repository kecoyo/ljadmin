package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "设备的查询参数")
public class DeviceQueryDTO {

    @Schema(description = "设备IDs", example = "1,2,3")
    private String ids = "";

    @Schema(description = "设备名称", example = "华为")
    private String name = "";

    @Schema(description = "所在地域", example = "1")
    private Integer areaId = 0;

    @Schema(description = "设备联系人", example = "张三")
    private String liaison = "";

    @Schema(description = "设备手机号", example = "13800138000")
    private String phone = "";
}
