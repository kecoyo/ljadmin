package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmkj.ljadmin.api.domain.Provider;
import com.dmkj.ljadmin.api.domain.SchoolCard;

/**
 * 学校班牌 - Mapper 测试类
 */
@SpringBootTest
public class SchoolCardMapperTest {

    private final int operator = 1000259; // 操作人ID

    @Autowired
    private SchoolCardMapper schoolCardMapper;

    @Test
    void getSchoolCardList() {
        List<SchoolCard> list = schoolCardMapper.getSchoolCardList("1144,1145,1146");
        System.out.println(list);
        assert list.size() > 0;
    }

    @Test
    void getSchoolCardInfo() {
        SchoolCard info = schoolCardMapper.getSchoolCardInfo(1144);
        System.out.println(info);
        // assert provider != null;
    }

    @Test
    void saveSchoolCard() {
        int rowCnt = schoolCardMapper.saveSchoolCard(1175, 100, 130000, 130100, 130102, "测试学校", operator);
        System.out.println(rowCnt);
        assert rowCnt == 1;
    }

    @Test
    void deleteSchoolCard() {
        int rowCnt = schoolCardMapper.deleteSchoolCard(1175, operator);
        System.out.println(rowCnt);
        assert rowCnt == 1;
    }

}
