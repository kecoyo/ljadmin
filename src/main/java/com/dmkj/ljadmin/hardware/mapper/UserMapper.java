package com.dmkj.ljadmin.hardware.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.dmkj.ljadmin.hardware.domain.User;

@Mapper
public interface UserMapper {

    /**
     * 分页查找用户信息列表
     *
     * @param userid   用户ID，>=0
     * @param userKey  用户姓名或手机号，可为空
     * @param role     用户角色，>=0，0-全部，1-超级管理员，2-管理员，3-运维人员
     * @param pageIdx  页码，>=1
     * @param pageSize 每页记录数，>=1
     * @return
     */
    @Select("call d_banpai_mgr.p_get_user_info(0,#{userKey},#{role},0,#{pageIdx},#{pageSize})")
    @Options(statementType = StatementType.CALLABLE)
    List<User> queryUserList(@Param("userKey") String userKey, @Param("role") int role,
            @Param("pageIdx") int pageIdx, @Param("pageSize") int pageSize);

    /**
     * 获取用户信息
     *
     * @param userid
     * @return
     */
    @Select("call d_banpai_mgr.p_get_user_info(#{userid},'',3,0,1,1)")
    @Options(statementType = StatementType.CALLABLE)
    User getUserInfo(@Param("userid") int userid);

    /**
     * 新增用户
     *
     * @param userid    用户ID
     * @param name      姓名
     * @param phone     手机号
     * @param role      角色, 允许范围 2-管理员, 3-运维人员
     * @param areaRange 区域范围
     * @param operator  操作人ID, >0
     * @return
     */
    @Select("call d_banpai_mgr.p_add_user_info(#{userid},#{name},#{phone},#{role},#{areaRange},#{operator})")
    @Options(statementType = StatementType.CALLABLE)
    int addUser(@Param("userid") int userid, @Param("name") String name, @Param("phone") String phone,
            @Param("role") int role, @Param("areaRange") String areaRange, @Param("operator") int operator);

    /**
     * 修改用户
     *
     * @param userid    用户ID
     * @param role      角色, 允许范围 2-管理员, 3-运维人员
     * @param areaRange 区域范围, 多个地域ID以逗号分隔
     * @param operator  操作人ID, >0
     * @return
     */
    @Select("call d_banpai_mgr.p_update_user_info(#{userid},#{role},#{areaRange},#{operator})")
    @Options(statementType = StatementType.CALLABLE)
    int updateUser(@Param("userid") int userid, @Param("role") int role, @Param("areaRange") String areaRange,
            @Param("operator") int operator);

    /**
     * 删除用户
     *
     * @param userid   用户ID
     * @param operator 操作人ID
     * @return
     */
    @Select("call d_banpai_mgr.p_set_user_info_status(#{userid},1,#{operator})")
    @Options(statementType = StatementType.CALLABLE)
    int deleteUser(@Param("userid") int userid, @Param("operator") int operator);
}
