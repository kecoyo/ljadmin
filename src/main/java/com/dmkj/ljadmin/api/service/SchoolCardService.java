package com.dmkj.ljadmin.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.api.domain.SchoolCard;
import com.dmkj.ljadmin.api.domain.dto.SchoolCardQueryDTO;
import com.dmkj.ljadmin.api.domain.dto.SchoolCardSaveDTO;
import com.dmkj.ljadmin.api.mapper.SchoolCardMapper;
import com.dmkj.ljadmin.common.exception.BadRequestException;
import com.dmkj.ljadmin.common.utils.SecurityUtils;

/**
 * 学校班牌配置管理 - 业务逻辑
 */
@Service
public class SchoolCardService {

    private final int type = 1; // 学校班牌

    @Autowired
    private SchoolCardMapper deviceMapper;

    /**
     * 获取学校班牌配置列表
     *
     * @param dto
     * @return
     */
    public List<SchoolCard> getSchoolCardList(SchoolCardQueryDTO dto) {
        // return deviceMapper.getSchoolCardList(null, dto.getName(), dto.getAreaId(),
        // dto.getLiaison(), dto.getPhone(),
        // dto.getPage(), dto.getPageSize());

        Integer userId = SecurityUtils.getCurrentUserId();

        return null;
    }

    /**
     * 获取学校班牌配置信息
     *
     * @param id
     * @return
     */
    public SchoolCard getSchoolCardInfo(int id) {
        // SchoolCard info = deviceMapper.getSchoolCardInfo(id);
        // if (info == null) {
        // throw new BadRequestException("学校班牌配置不存在");
        // }
        // return info;
        return null;
    }

    /**
     * 修改学校班牌配置
     *
     * @param dto
     * @return
     */
    public void saveSchoolCard(SchoolCardSaveDTO dto) {
        Integer userId = SecurityUtils.getCurrentUserId();

        // // 修改学校班牌配置
        // int rowCnt = deviceMapper.saveSchoolCard(dto.getId(), dto.getName(),
        // dto.getAreaId(), dto.getLiaison(),
        // dto.getPhone(), dto.getComment(), dto.getUpdateTime(), userId);

        // // rowCnt：0失败 1成功 2参数错误 3学校班牌配置不存在
        // if (rowCnt == 1) {
        // // 成功
        // } else if (rowCnt == 2) {
        // throw new BadRequestException("参数错误");
        // } else if (rowCnt == 3) {
        // throw new BadRequestException("学校班牌配置不存在");
        // } else {
        // throw new BadRequestException("修改学校班牌配置失败");
        // }

    }

    /**
     * 删除学校班牌配置
     *
     * @param id
     * @return
     */
    public void deleteSchoolCard(int id) {
        // 当前登录用户ID
        int userId = SecurityUtils.getCurrentUserId();

        // 删除学校班牌配置
        int rowCnt = deviceMapper.deleteSchoolCard(id, userId);

        // rowCnt：0失败 1成功 2参数错误
        if (rowCnt == 1) {
            // 成功
        } else if (rowCnt == 2) {
            throw new BadRequestException("参数错误");
        } else {
            throw new BadRequestException("删除学校班牌配置失败");
        }
    }

    /**
     * 批量删除学校班牌
     *
     * @param ids
     */
    public void deleteSchoolCard(Set<Integer> ids) {
        for (Integer id : ids) {
            this.deleteSchoolCard(id);
        }
    }
}
