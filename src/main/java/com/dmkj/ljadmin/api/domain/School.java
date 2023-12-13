package com.dmkj.ljadmin.api.domain;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "学校信息")
public class School {
    @Schema(description = "学校ID")
    Integer id;
    @Schema(description = "学校名称")
    String name;
    /** 学校属性 1省直属 2市直属 0无 */
    @Schema(description = "学校属性 1省直属 2市直属 0无")
    String mode;
    /** 学校阶段 */
    @Schema(description = "学校阶段")
    Integer phase;
    /** 学校属性 1省直属 2市直属 0无 */
    Integer property;
    /** 学校识别码 */
    String idCode;
    /** 加入模式 1禁止加入 2自由加入 4批准加入 */
    Integer modeAdmin;
    /** 省ID */
    Integer province;
    /** 市ID */
    Integer city;
    /** 区县ID */
    Integer county;
    /** 父学校ID */
    Integer pid;
    /** 说明 */
    String comment;
    /** 状态 0正常 1删除 */
    Integer status;
    /** 注册时间 */
    Date createTime;
    /** 修改时间 */
    Date updateTime;
}