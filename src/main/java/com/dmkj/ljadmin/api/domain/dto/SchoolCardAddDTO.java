package com.dmkj.ljadmin.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "学校班牌的添加参数")
public class SchoolCardAddDTO {

    @Schema(description = "学校ID", example = "1")
    @NotNull(message = "学校ID不能为空")
    private Integer schoolId;

    @Schema(description = "预计安装数量", example = "30")
    @NotNull(message = "预计安装数量不能为空")
    @Min(value = 0, message = "预计安装数量不能小于0")
    private Integer expectCard;
}
