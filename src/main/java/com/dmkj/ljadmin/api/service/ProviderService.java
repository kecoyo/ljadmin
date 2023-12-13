package com.dmkj.ljadmin.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.api.domain.Provider;
import com.dmkj.ljadmin.api.domain.ProviderDevice;
import com.dmkj.ljadmin.api.domain.dto.ProviderAddDTO;
import com.dmkj.ljadmin.api.domain.dto.ProviderDeviceDTO;
import com.dmkj.ljadmin.api.domain.dto.ProviderQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.ProviderUpdateDTO;
import com.dmkj.ljadmin.api.mapper.ProviderDeviceMapper;
import com.dmkj.ljadmin.api.mapper.ProviderMapper;
import com.dmkj.ljadmin.common.exception.BadRequestException;

/**
 * 硬件供应商管理
 */

@Service
public class ProviderService {

    private final int type = 2; // 硬件供应商

    @Autowired
    private ProviderMapper providerMapper;

    @Autowired
    private ProviderDeviceMapper providerDeviceMapper;

    /**
     * 获取硬件供应商列表
     *
     * @param dto
     * @return
     */
    public List<Provider> getProviderList(ProviderQueryDTO dto) {
        return providerMapper.getProviderList(dto.getIds(), dto.getName(), dto.getAreaId(), dto.getLiaison(),
                dto.getPhone(), type);
    }

    /**
     * 获取硬件供应商信息
     *
     * @param id
     * @return
     */
    public Provider getProviderInfo(int id) {
        Provider info = providerMapper.getProviderInfo(id, type);
        if (info == null) {
            throw new BadRequestException("供应商不存在");
        }
        return info;
    }

    /**
     * 添加硬件供应商
     *
     * @param dto
     * @return
     */
    public int addProvider(ProviderAddDTO dto) {
        // 新提交的设备列表
        List<ProviderDeviceDTO> devices = dto.getDevices();

        // 检查新设备列表中 '设备类型+设备名称' 是否有重复
        Set<String> uniqueNames = devices.stream()
                .map(device -> device.getDeviceType() + device.getDeviceMode())
                .collect(Collectors.toSet());
        // 如果uniqueNames的大小等于devices的数量，则说明没有重复的名称
        if (uniqueNames.size() != devices.size()) {
            throw new BadRequestException("设备类型+设备名称 有重复");
        }

        int rowCnt = providerMapper.addProvider(dto.getName(), dto.getAreaId(), dto.getLiaison(), dto.getPhone(), type);
        int providerId = 0;

        // rowCnt：0失败 2参数错误 >100成功返回供应商ID
        if (rowCnt > 100) {
            providerId = rowCnt;
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("添加硬件供应商失败");
        }

        // 新增的设备信息
        for (ProviderDeviceDTO device : devices) {
            providerDeviceMapper.addProviderDevice(providerId, device.getDeviceType(), device.getDeviceMode());
        }

        return providerId;
    }

    /**
     * 修改硬件供应商信息
     *
     * @param dto
     * @return
     */
    public void updateProvider(ProviderUpdateDTO dto) {
        // 新提交的设备列表
        List<ProviderDeviceDTO> devices = dto.getDevices();

        // 检查新设备列表中 '设备类型+设备名称' 是否有重复
        Set<String> uniqueNames = devices.stream()
                .map(device -> device.getDeviceType() + device.getDeviceMode())
                .collect(Collectors.toSet());
        // 如果uniqueNames的大小等于devices的数量，则说明没有重复的名称
        if (uniqueNames.size() != devices.size()) {
            throw new BadRequestException("设备类型+设备名称 有重复");
        }

        // 修改供应商信息
        int rowCnt = providerMapper.updateProvider(dto.getId(), dto.getName(), dto.getAreaId(), dto.getLiaison(),
                dto.getPhone());

        // rowCnt：0失败 1成功 2参数错误 3供应商不存在
        if (rowCnt == 1) {
            // 成功
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else if (rowCnt == 3) {
            throw new BadRequestException("供应商不存在");
        } else {
            throw new BadRequestException("修改硬件供应商失败");
        }

        // 获取旧的设备列表
        List<ProviderDevice> oldDevices = providerDeviceMapper.getProviderDeviceList("", dto.getId());

        // 要修改的设备ID列表
        List<Integer> updateDeviceIds = devices.stream().filter(device -> device.getId() != null)
                .map(device -> device.getId()).collect(Collectors.toList());

        // 删除不在更新列表中的设备
        for (ProviderDevice device : oldDevices) {
            if (!updateDeviceIds.contains(device.getId())) {
                providerDeviceMapper.deleteProviderDevice(device.getId());
            }
        }

        // 更新和新增设备
        for (ProviderDeviceDTO device : devices) {
            if (device.getId() != null && device.getId() > 0) {
                providerDeviceMapper.updateProviderDevice(device.getId(), device.getDeviceType(),
                        device.getDeviceMode());
            } else {
                providerDeviceMapper.addProviderDevice(dto.getId(), device.getDeviceType(), device.getDeviceMode());
            }
        }
    }

    /**
     * 删除硬件供应商
     *
     * @param id
     * @return
     */
    public void deleteProvider(int id) {
        int rowCnt = providerMapper.deleteProvider(id);

        // rowCnt：0失败 1成功 2参数错误
        if (rowCnt == 1) {
            // 成功
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("删除硬件供应商失败");
        }
    }

    /**
     * 批量删除硬件供应商
     *
     * @param ids
     */
    public void deleteProvider(Set<Integer> ids) {
        for (Integer id : ids) {
            this.deleteProvider(id);
        }
    }
}
