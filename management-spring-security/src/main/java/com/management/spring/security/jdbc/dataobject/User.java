package com.management.spring.security.jdbc.dataobject;

import lombok.Data;

/**
 * @Author xiqiuwei
 * @Date Created in 20:48 2020/5/26
 * @Description
 * @Modified By:
 */
@Data
public class User {
    private String loginAccount;
    private String loginPass;
    private String userName;
    private String userHead;
    private String userPhone;
    private String userEmail;
    private Integer userSex;
    private String userBirthday;
    private String registerTime;
    private String departmentKey;
}
