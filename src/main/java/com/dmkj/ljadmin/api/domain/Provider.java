package com.dmkj.ljadmin.api.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "供应商信息")
public class Provider {

    @Schema(description = "供应商ID")
    private Integer id;

    @Schema(description = "供应商名称")
    private String name;

    @Schema(description = "所在地域")
    private Integer areaId;

    @Schema(description = "供应商联系人")
    private String liaison;

    @Schema(description = "供应商手机号")
    private String phone;

    @Schema(description = "供应商类型, 1-软件 2-硬件")
    private Integer providerType;
}
