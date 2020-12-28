package com.hand.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author ludongpeng
 * @Date 2020/12/11 15:17
 * @Description:
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;

    private Department department;
    private Date birth;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Department department, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }

}