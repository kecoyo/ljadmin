package com.dmkj.ljadmin.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.api.domain.Provider;
import com.dmkj.ljadmin.api.domain.dto.VendorAddDTO;
import com.dmkj.ljadmin.api.domain.dto.VendorQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.VendorUpdateDTO;
import com.dmkj.ljadmin.api.mapper.ProviderMapper;
import com.dmkj.ljadmin.common.exception.BadRequestException;

/**
 * 软件供应商管理
 */
@Service
public class VendorService {

    private final int type = 1; // 软件供应商

    @Autowired
    private ProviderMapper providerMapper;

    /**
     * 获取供应商列表
     *
     * @param dto
     * @return
     */
    public List<Provider> getVendorList(VendorQueryDTO dto) {
        return providerMapper.getProviderList(dto.getIds(), dto.getName(), dto.getAreaId(), dto.getLiaison(),
                dto.getPhone(), type);
    }

    /**
     * 获取供应商信息
     *
     * @param id
     * @return
     */
    public Provider getVendorInfo(int id) {
        Provider info = providerMapper.getProviderInfo(id, type);
        if (info == null) {
            throw new BadRequestException("供应商不存在");
        }
        return info;
    }

    /**
     * 添加供应商
     *
     * @param dto
     * @return
     */
    public int addVendor(VendorAddDTO dto) {
        int rowCnt = providerMapper.addProvider(dto.getName(), dto.getAreaId(), dto.getLiaison(), dto.getPhone(), type);
        int providerId = 0;

        // rowCnt：0失败 2参数错误 >100成功返回供应商ID
        if (rowCnt > 100) {
            providerId = rowCnt;
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("添加供应商失败");
        }

        return providerId;
    }

    /**
     * 修改供应商
     *
     * @param dto
     * @return
     */
    public void updateVendor(VendorUpdateDTO dto) {
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
            throw new BadRequestException("修改供应商失败");
        }
    }

    /**
     * 删除供应商
     *
     * @param id
     * @return
     */
    public void deleteVendor(int id) {
        int rowCnt = providerMapper.deleteProvider(id);

        // rowCnt：0失败 1成功 2参数错误
        if (rowCnt == 1) {
            // 成功
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("删除供应商失败");
        }
    }

    /**
     * 批量删除供应商
     *
     * @param ids
     */
    public void deleteVendor(Set<Integer> ids) {
        for (Integer id : ids) {
            this.deleteVendor(id);
        }
    }
}
