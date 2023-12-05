package com.dmkj.ljadmin.business.service;

import com.dmkj.ljadmin.business.dao.SchoolDao;
import com.dmkj.ljadmin.business.model.SchoolInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    public List<SchoolInfo> getSchoolList() {
        Integer province = 32;
        Integer city = 384;
        Integer county = 3407;
        Integer phase = 2;
        String name = "";
        Integer pageIndex = 1;
        Integer pageSize = 10;
        return schoolDao.getSchoolList(province, city, county, phase, name, pageIndex, pageSize);
    }

    public SchoolInfo getSchoolInfo(Integer id) {
        return schoolDao.getSchoolInfo(id);
    }
}
