package com.dmkj.ljadmin.common.dto;

import lombok.Data;

@Data
public class UserDto implements java.io.Serializable {
    private Long id;

    private String name;

    private Integer age;

    private String email;

}
