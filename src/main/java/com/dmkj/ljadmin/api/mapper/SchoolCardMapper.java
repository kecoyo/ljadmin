package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.dmkj.ljadmin.api.domain.SchoolCard;

/**
 * 学校班牌 - 数据库访问接口
 */
@Mapper
public interface SchoolCardMapper {

    /**
     * 批量获取学校安装设备数量信息
     *
     * @param schoolIds 学校ID列表，以逗号分隔
     * @return
     */
    @Select("call d_banpai_mgr.p_batchget_school_cards(#{schoolIds})")
    @Options(statementType = StatementType.CALLABLE)
    List<SchoolCard> getSchoolCardList(@Param("schoolIds") String schoolIds);

    /**
     * 获取学校安装设备数量信息
     *
     * @param schoolId 学校ID，>0
     * @return
     */
    @Select("call d_banpai_mgr.p_batchget_school_cards(#{schoolId})")
    @Options(statementType = StatementType.CALLABLE)
    SchoolCard getSchoolCardInfo(@Param("schoolId") int schoolId);

    /**
     * 保存学校安装设备数量设置信息
     *
     * @param schoolId   学校ID，>0
     * @param expectCard 预计安装数量，>0
     * @param province   学校的省ID，>0
     * @param city       学校的市ID，>0
     * @param county     学校的区县ID，>0
     * @param schoolName 学校名称，不能为空
     * @param operator   操作者ID，>0
     * @return rowCnt：0失败 1成功 2参数错误
     */
    @Select("call d_banpai_mgr.p_save_school_cards(#{schoolId},#{expectCard},#{province},#{city},#{county},#{schoolName},#{operator})")
    @Options(statementType = StatementType.CALLABLE)
    int saveSchoolCard(@Param("schoolId") int schoolId, @Param("expectCard") int expectCard,
            @Param("province") int province, @Param("city") int city, @Param("county") int county,
            @Param("schoolName") String schoolName, @Param("operator") int operator);

    /**
     * 删除学校安装设备数量设置信息
     *
     * @param schoolId 学校ID，>0
     * @param operator 操作者ID，>0
     * @return rowCnt：0失败 1成功 2参数错误
     */
    @Select("call d_banpai_mgr.p_del_school_cards(#{schoolId},#{operator})")
    @Options(statementType = StatementType.CALLABLE)
    int deleteSchoolCard(@Param("schoolId") int schoolId, @Param("operator") int operator);
}
