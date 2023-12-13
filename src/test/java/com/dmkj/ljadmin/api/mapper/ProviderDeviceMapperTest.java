package com.dmkj.ljadmin.api.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmkj.ljadmin.api.domain.ProviderDevice;

/**
 * 硬件供应商的设备信息 Mapper 测试类
 */
@SpringBootTest
public class ProviderDeviceMapperTest {

    @Autowired
    private ProviderDeviceMapper providerDeviceMapper;

    @Test
    void getProviderDeviceList() {
        List<ProviderDevice> list = providerDeviceMapper.getProviderDeviceList("", 111);
        System.out.println(list);
        assert list.size() >= 0;
    }

    @Test
    void getProviderDeviceInfo() {
        ProviderDevice provider = providerDeviceMapper.getProviderDeviceInfo(13, 111);
        System.out.println(provider);
        // assert provider != null;
    }

    @Test
    void addProviderDevice() {
        int id = providerDeviceMapper.addProviderDevice(111, 1, "测试型号");
        System.out.println(id);
        assert id > 10;
    }

    @Test
    void updateProviderDevice() {
        int rowCnt = providerDeviceMapper.updateProviderDevice(12, 1, "测试型号");
        System.out.println(rowCnt);
        assert rowCnt == 1;
    }

    @Test
    void deleteProviderDevice() {
        int rowCnt = providerDeviceMapper.deleteProviderDevice(12);
        System.out.println(rowCnt);
        assert rowCnt == 1;
    }

}
