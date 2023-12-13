package com.dmkj.ljadmin.api.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "设备信息")
public class Device {

    @Schema(description = "设备ID")
    private Integer id;

    @Schema(description = "设备名称")
    private String name;

    @Schema(description = "所在地域")
    private Integer areaId;

    @Schema(description = "设备联系人")
    private String liaison;

    @Schema(description = "设备手机号")
    private String phone;

    @Schema(description = "设备类型, 1-软件 2-硬件")
    private Integer deviceType;
}
