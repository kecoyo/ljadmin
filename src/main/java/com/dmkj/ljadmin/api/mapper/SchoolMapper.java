package com.dmkj.ljadmin.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.dmkj.ljadmin.api.domain.School;

import java.util.List;

@Mapper
public interface SchoolMapper {

    /**
     * 获取指定省市区县下的学校列表
     *
     * @param province 省ID，大于0时有效条件
     * @param city     市ID，大于0时有效条件
     * @param county   区县ID，大于0时有效条件
     * @param phase    学段，大于0时有效条件
     * @param name     不为空时有效条件，模糊匹配
     * @param pageIdx  页面索引。从1开始，小于1时报错。
     * @param pageSize 页面大小。小于1时报错。
     * @return
     */
    @Select("call d_user_info.p_get_school_list(#{province},#{city},#{county},#{phase},#{name},#{pageIdx},#{pageSize})")
    @Options(statementType = StatementType.CALLABLE)
    List<School> getSchoolList(@Param("province") int province, @Param("city") int city,
            @Param("county") int county, @Param("phase") int phase, @Param("name") String name,
            @Param("pageIdx") int pageIdx, @Param("pageSize") int pageSize);

    /**
     * 获取指定地域下的学校列表
     *
     * @param areaId   地域ID, >0
     * @param phase    学段，大于0时有效条件
     * @param name     不为空时有效条件，模糊匹配
     * @param pageIdx  页面索引。从1开始，小于1时报错。
     * @param pageSize 页面大小。小于1时报错。
     */
    @Select("call d_user_info.p_get_school_list_byAreaId(#{areaId},#{phase},#{name},#{pageIdx},#{pageSize})")
    @Options(statementType = StatementType.CALLABLE)
    List<School> getSchoolListByAreaId(@Param("areaId") int areaId, @Param("phase") int phase,
            @Param("name") String name, @Param("pageIdx") int pageIdx, @Param("pageSize") int pageSize);

    /**
     * 获取学校信息
     *
     * @param id 学校ID
     * @return
     */
    @Select("call d_user_info.p_get_school_info(#{id})")
    @Options(statementType = StatementType.CALLABLE)
    School getSchoolInfo(@Param("id") int id);
}
