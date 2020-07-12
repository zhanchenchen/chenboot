package com.learn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
@Data
public class User implements Serializable {
    @NotBlank(message = "姓名不能为空！")
    private String name;
    @Pattern(regexp = "^[0-9]{1,2}$",message = "年龄格式错误！")
    private String age;
    @Digits(integer = 6,fraction = 2,message = "工资格式错误！")
    private Double salary;
    @NotNull(message = "日期不能为空！")
    @Past(message = "日期格式错误！")
    private Date birthday;
    @Email(regexp = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$",message = "邮箱格式不正确！")
    private String email;
}
