package com.dmkj.ljadmin.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmkj.ljadmin.api.domain.School;
import com.dmkj.ljadmin.api.mapper.SchoolMapper;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    public List<School> getSchoolList() {
        Integer province = 32;
        Integer city = 384;
        Integer county = 3407;
        Integer phase = 2;
        String name = "";
        Integer pageIndex = 1;
        Integer pageSize = 10;
        return schoolMapper.getSchoolList(province, city, county, phase, name, pageIndex, pageSize);
    }

    public School getSchoolInfo(Integer id) {
        return schoolMapper.getSchoolInfo(id);
    }
}
