package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.dmkj.ljadmin.api.domain.Provider;

/**
 * 供应商 - 数据库访问接口
 */
@Mapper
public interface ProviderMapper {

    /**
     * 获取供应商信息列表
     *
     * @param ids     供应商IDs，逗号分隔，可为空
     * @param name    供应商名称，模糊匹配，可为空
     * @param areaId  供应商所在地域ID，>=0
     * @param liaison 供应商联系人，模糊匹配，可为空
     * @param phone   供应商手机号，精准匹配，可为空
     * @param type    供应商类型：1软件 2硬件
     * @return
     */
    @Select("call d_banpai_mgr.p_get_provider(#{ids},#{name},#{areaId},#{liaison},#{phone},#{type})")
    @Options(statementType = StatementType.CALLABLE)
    List<Provider> getProviderList(@Param("ids") String ids, @Param("name") String name, @Param("areaId") int areaId,
            @Param("liaison") String liaison, @Param("phone") String phone, @Param("type") int type);

    /**
     * 获取供应商信息
     *
     * @param userid
     * @return
     */
    @Select("call d_banpai_mgr.p_get_provider(#{id},'', 0, '', '',#{type})")
    @Options(statementType = StatementType.CALLABLE)
    Provider getProviderInfo(@Param("id") int id, @Param("type") int type);

    /**
     * 新增供应商
     *
     * @param name    供应商名称，不能为空
     * @param areaId  供应商所在地域ID，>0
     * @param liaison 供应商联系人，不能为空
     * @param phone   供应商手机号，不能为空
     * @param type    供应商类型：1软件 2硬件
     * @return rowCnt：0失败 2参数错误 >100成功返回供应商ID
     */
    @Select("call d_banpai_mgr.p_add_provider(#{name},#{areaId},#{liaison},#{phone},#{type})")
    @Options(statementType = StatementType.CALLABLE)
    int addProvider(@Param("name") String name, @Param("areaId") int areaId, @Param("liaison") String liaison,
            @Param("phone") String phone, @Param("type") int type);

    /**
     * 修改供应商
     *
     * @param id      供应商ID，>0
     * @param name    供应商名称，不能为空
     * @param areaId  供应商所在地域ID，>0
     * @param liaison 供应商联系人，不能为空
     * @param phone   供应商手机号，不能为空
     * @return rowCnt：0失败 1成功 2参数错误 3供应商不存在
     */
    @Select("call d_banpai_mgr.p_update_provider(#{id},#{name},#{areaId},#{liaison},#{phone})")
    @Options(statementType = StatementType.CALLABLE)
    int updateProvider(@Param("id") int id, @Param("name") String name, @Param("areaId") int areaId,
            @Param("liaison") String liaison, @Param("phone") String phone);

    /**
     * 删除供应商
     *
     * @param id 供应商ID，>0
     * @return rowCnt：0失败 1成功 2参数错误
     */
    @Select("call d_banpai_mgr.p_del_provider(#{id})")
    @Options(statementType = StatementType.CALLABLE)
    int deleteProvider(@Param("id") int id);
}
