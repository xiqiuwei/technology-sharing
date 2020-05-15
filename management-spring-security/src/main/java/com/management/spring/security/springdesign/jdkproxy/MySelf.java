package com.management.spring.security.springdesign.jdkproxy;

/**
 * @Author xiqiuwei
 * @Date Created in 20:09 2020/5/10
 * @Description
 * @Modified By:
 */


public class MySelf implements Person {
    private String name;
    private String gender;
    private Integer age;

    public MySelf(){}
    public MySelf(String name, String gender, Integer age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public void introduce() {
        System.out.print("姓名: " + this.name + "\n\r");
        System.out.print("性别: " + this.gender + "\n\r");
        System.out.print("年龄: " + this.age + "\n\r");
    }

    @Override
    public void blindDate() {
        System.err.print("相亲去自我介绍:" + "\n\r");
        this.introduce();
    }
}
