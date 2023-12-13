package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.dmkj.ljadmin.api.domain.ProviderDevice;

/**
 * 硬件供应商的设备信息
 */
@Mapper
public interface ProviderDeviceMapper {

    /**
     * 获取硬件供应商的设备信息列表
     *
     * @param ids        硬件供应商设备IDs，逗号分隔，可为空
     * @param providerId 硬件供应商ID，>=0
     * @return
     */
    @Select("call d_banpai_mgr.p_get_provider_device(#{ids},#{providerId})")
    @Options(statementType = StatementType.CALLABLE)
    List<ProviderDevice> getProviderDeviceList(@Param("ids") String ids, @Param("providerId") int providerId);

    /**
     * 获取硬件供应商的设备信息
     *
     * @param id         硬件供应商设备ID，>0
     * @param providerId 硬件供应商ID，>=0
     * @return
     */
    @Select("call d_banpai_mgr.p_get_provider_device(#{id},#{providerId})")
    @Options(statementType = StatementType.CALLABLE)
    ProviderDevice getProviderDeviceInfo(@Param("id") int id, @Param("providerId") int providerId);

    /**
     * 新建硬件供应商的设备信息
     *
     * @param providerId 硬件供应商ID，>0
     * @param deviceType 设备类型ID，>0
     * @param mode       设备型号，不能为空
     * @return rowCnt：0失败 2参数错误 3硬件供应商不存在 4设备类型不存在 >10成功返回硬件供应商设备类型型号ID
     */
    @Select("call d_banpai_mgr.p_add_provider_device(#{providerId},#{deviceType},#{mode})")
    @Options(statementType = StatementType.CALLABLE)
    int addProviderDevice(@Param("providerId") int providerId, @Param("deviceType") int deviceType,
            @Param("mode") String mode);

    /**
     * 修改硬件供应商的设备信息
     *
     * @param id         硬件供应商设备ID，>0
     * @param deviceType 设备类型ID，>0
     * @param mode       设备型号，不能为空
     * @return rowCnt：0失败 1成功 2参数错误 3硬件供应商设备不存在 4设备类型不存在 5设备信息已存在
     */
    @Select("call d_banpai_mgr.p_update_provider_device(#{id},#{deviceType},#{mode})")
    @Options(statementType = StatementType.CALLABLE)
    int updateProviderDevice(@Param("id") int id, @Param("deviceType") int deviceType, @Param("mode") String mode);

    /**
     * 删除硬件供应商的设备信息
     *
     * @param id 硬件供应商设备ID，>0
     * @return rowCnt：0失败 1成功 2参数错误 3硬件供应商设备不存在 4设备类型不存在 5设备信息已存在
     */
    @Select("call d_banpai_mgr.p_del_provider_device(#{id})")
    @Options(statementType = StatementType.CALLABLE)
    int deleteProviderDevice(@Param("id") int id);
}
