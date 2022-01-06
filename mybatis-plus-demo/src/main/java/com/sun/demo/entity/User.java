package com.sun.demo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jackson
 * @version 1.0
 * @description
 * @date 2021/9/9
 **/
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
