package com.dmkj.ljadmin.api.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "学校班牌信息")
public class SchoolCard {

    @Schema(description = "学校班牌ID")
    private Integer id;

    @Schema(description = "学校班牌名称")
    private String name;

    @Schema(description = "所在地域")
    private Integer areaId;

    @Schema(description = "学校班牌联系人")
    private String liaison;

    @Schema(description = "学校班牌手机号")
    private String phone;

    @Schema(description = "学校班牌类型, 1-软件 2-硬件")
    private Integer schoolCardType;
}
