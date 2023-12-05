package com.dmkj.hardware.dao;

import java.util.List;

import com.dmkj.hardware.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
     * 查询所有
     */
    @Select("call d_banpai_mgr.p_get_user_info(:_userid,:_userKey,:_role,:_pageIdx,:_pageSize)")
    List<User> findAll();
}
