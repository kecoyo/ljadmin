package com.dmkj.ljadmin.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProviderType {

    SOFTWARE(1, "软件"),
    HARDWARE(2, "硬件");

    private final Integer id;
    private final String name;

}
