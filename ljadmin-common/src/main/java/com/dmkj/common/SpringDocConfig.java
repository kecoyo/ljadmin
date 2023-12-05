package com.dmkj.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        Info info = new Info().title("LJAdmin 后台管理系统API文档").version("v0.0.1");
        return new OpenAPI().info(info);
    }

}