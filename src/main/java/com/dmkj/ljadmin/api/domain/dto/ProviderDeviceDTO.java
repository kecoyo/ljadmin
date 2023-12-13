package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "硬件供应商的设备信息")
public class ProviderDeviceDTO {

    @Schema(description = "设备ID", example = "0")
    private Integer id;

    @Schema(description = "设备类型ID", example = "1")
    @NotNull(message = "设备类型ID不能为空")
    private Integer deviceType;

    @Schema(description = "设备型号", example = "华为P30")
    @NotBlank(message = "设备型号不能为空")
    private String deviceMode;

}
