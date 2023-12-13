package com.dmkj.ljadmin.api.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "硬件供应商设备信息")
public class ProviderDevice {

    @Schema(description = "硬件供应商设备类型型号ID")
    private Integer id;

    @Schema(description = "硬件供应商ID")
    private Integer providerId;

    @Schema(description = "设备类型ID")
    private String deviceTypeName;

    @Schema(description = "设备型号")
    private String deviceMode;

}
