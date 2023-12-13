package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmkj.ljadmin.api.domain.Provider;

/**
 * 供应商信息 Mapper 测试类
 */
@SpringBootTest
public class ProviderMapperTest {

    @Autowired
    private ProviderMapper providerMapper;

    @Test
    void getProviderList() {
        List<Provider> list = providerMapper.getProviderList("", "", 0, "", "", 1);
        System.out.println(list);
        assert list.size() > 0;
    }

    @Test
    void getProviderInfo() {
        Provider provider = providerMapper.getProviderInfo(108, 1);
        System.out.println(provider);
        // assert provider != null;
    }

    @Test
    void addProvider() {
        int providerId = providerMapper.addProvider("测试供应商", 3407, "测试联系人", "13800000000", 2);
        System.out.println(providerId);
        assert providerId > 0;
    }

    @Test
    void updateProvider() {
        int rowCnt = providerMapper.updateProvider(108, "测试供应商", 3407, "张三", "13800000000");
        System.out.println(rowCnt);
        assert rowCnt == 1;
    }

    @Test
    void deleteProvider() {
        int rowCnt = providerMapper.deleteProvider(108);
        System.out.println(rowCnt);
        assert rowCnt == 1;
    }

}
