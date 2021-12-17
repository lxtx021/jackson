package com.lxtx.collection;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2021/5/20
 **/
@Getter
@Setter
public class Employee {
    private int no ;
    private String name;
    public Employee() {
        super();
    }
    public Employee(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return no == employee.no && name.equals(employee.name);
    }

    /**
     * 重写hashCode 方法
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "编号："+no+"姓名："+name;
    }
}
