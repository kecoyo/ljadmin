package com.dmkj.ljadmin.business.dao;

import com.dmkj.ljadmin.business.model.SchoolInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface SchoolDao {

    /**
     * 获取指定省市区县下的学校列表
     * 
     * @return 学校列表
     */
    @Select("call d_user_info.p_get_school_list(#{province},#{city},#{county},#{phase},#{name},#{pageIndex},#{pageSize})")
    @Options(statementType = StatementType.CALLABLE)
    List<SchoolInfo> getSchoolList(@Param("province") Integer province, @Param("city") Integer city,
                                   @Param("county") Integer county, @Param("phase") Integer phase, @Param("name") String name,
                                   @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 获取学校信息
     */
    @Select("call d_user_info.p_get_school_info(#{id})")
    @Options(statementType = StatementType.CALLABLE)
    SchoolInfo getSchoolInfo(@Param("id") Integer id);
}