package com.management.spring.security.springdesign.jdkproxy;

/**
 * @Author xiqiuwei
 * @Date Created in 20:20 2020/5/10
 * @Description
 * @Modified By:
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        Person person = (Person) new PersonProxy().getInstance(new MySelf("三土", "男", 29));
        person.getAge();
        person.blindDate();
    }
}
