package com.dmkj.ljadmin.business.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "学校信息")
public class SchoolInfo {
    @ApiModelProperty(value = "学校ID", required = true)
    Integer id;
    @ApiModelProperty(value = "学校名称", required = true)
    String name;
    /** 学校属性 1省直属 2市直属 0无 */
    String mode;
    /** 学校阶段 */
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
