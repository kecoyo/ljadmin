package com.dmkj.ljadmin.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.api.domain.Device;
import com.dmkj.ljadmin.api.domain.dto.DeviceAddDTO;
import com.dmkj.ljadmin.api.domain.dto.DeviceQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.DeviceUpdateDTO;
import com.dmkj.ljadmin.api.mapper.DeviceMapper;
import com.dmkj.ljadmin.common.exception.BadRequestException;

/**
 * 设备管理 - 业务逻辑
 */
@Service
public class DeviceService {

    private final int type = 1; // 软件设备

    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 获取设备列表
     *
     * @param dto
     * @return
     */
    public List<Device> getDeviceList(DeviceQueryDTO dto) {
        return deviceMapper.getDeviceList(dto.getIds(), dto.getName(), dto.getAreaId(), dto.getLiaison(),
                dto.getPhone(), type);
    }

    /**
     * 获取设备信息
     *
     * @param id
     * @return
     */
    public Device getDeviceInfo(int id) {
        Device info = deviceMapper.getDeviceInfo(id, type);
        if (info == null) {
            throw new BadRequestException("设备不存在");
        }
        return info;
    }

    /**
     * 添加设备
     *
     * @param dto
     * @return
     */
    public int addDevice(DeviceAddDTO dto) {
        int rowCnt = deviceMapper.addDevice(dto.getName(), dto.getAreaId(), dto.getLiaison(), dto.getPhone(), type);
        int deviceId = 0;

        // rowCnt：0失败 2参数错误 >100成功返回设备ID
        if (rowCnt > 100) {
            deviceId = rowCnt;
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("添加设备失败");
        }

        return deviceId;
    }

    /**
     * 修改设备
     *
     * @param dto
     * @return
     */
    public void updateDevice(DeviceUpdateDTO dto) {
        // 修改设备信息
        int rowCnt = deviceMapper.updateDevice(dto.getId(), dto.getName(), dto.getAreaId(), dto.getLiaison(),
                dto.getPhone());

        // rowCnt：0失败 1成功 2参数错误 3设备不存在
        if (rowCnt == 1) {
            // 成功
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else if (rowCnt == 3) {
            throw new BadRequestException("设备不存在");
        } else {
            throw new BadRequestException("修改设备失败");
        }
    }

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    public void deleteDevice(int id) {
        int rowCnt = deviceMapper.deleteDevice(id);

        // rowCnt：0失败 1成功 2参数错误
        if (rowCnt == 1) {
            // 成功
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("删除设备失败");
        }
    }

    /**
     * 批量删除设备
     *
     * @param ids
     */
    public void deleteDevice(Set<Integer> ids) {
        for (Integer id : ids) {
            this.deleteDevice(id);
        }
    }
}
