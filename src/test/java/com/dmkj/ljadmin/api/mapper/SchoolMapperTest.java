package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmkj.ljadmin.api.domain.School;
import com.dmkj.ljadmin.api.domain.SchoolCard;

/**
 * 学校 - Mapper 测试类
 */
@SpringBootTest
public class SchoolMapperTest {

    @Autowired
    private SchoolMapper schoolMapper;

    @Test
    void getSchoolList() {
        List<School> list = schoolMapper.getSchoolList(130000, 130100, 130105, 1, "", 1, 10);
        System.out.println(list);
        assert list.size() >= 0;
    }

    @Test
    void getSchoolListByAreaId() {
        List<School> list = schoolMapper.getSchoolListByAreaId(130105, 1, "", 1, 10);
        System.out.println(list);
        assert list.size() >= 0;
    }

    @Test
    void saveSchoolCard() {
        School info = schoolMapper.getSchoolInfo(1175);
        System.out.println(info);
        assert info != null;
    }

}
