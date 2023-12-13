package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "学校班牌的查询参数")
public class SchoolCardQueryDTO {

    @Schema(description = "所属省份", example = "0")
    private Integer province = 0;

    @Schema(description = "所属地市", example = "0")
    private Integer city = 0;

    @Schema(description = "所属区县", example = "0")
    private Integer county = 0;

    @Schema(description = "学校名称", example = "华为")
    private String schoolName = "";

    @Schema(description = "学校ID", example = "0")
    private Integer schoolId = 0;
}
