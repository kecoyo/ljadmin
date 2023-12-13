package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "设备的修改参数")
public class DeviceUpdateDTO {

    @Schema(description = "设备ID", example = "1")
    @NotNull(message = "ID不能为空")
    @Min(value = 1, message = "ID最小不能小于1")
    private Integer id;

    @Schema(description = "设备名称", example = "华为")
    @NotBlank(message = "名称不能为空")
    private String name;

    @Schema(description = "所在地域", example = "1")
    @NotNull(message = "地域不能为空")
    @Min(value = 1, message = "地域最小不能小于1")
    private Integer areaId;

    @Schema(description = "设备联系人", example = "张三")
    @NotBlank(message = "联系人不能为空")
    private String liaison;

    @Schema(description = "设备手机号", example = "13800138000")
    @NotBlank(message = "手机号不能为空")
    private String phone;
}
