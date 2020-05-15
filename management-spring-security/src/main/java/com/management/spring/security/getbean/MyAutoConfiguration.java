package com.management.spring.security.getbean;

import com.management.spring.security.annotation.ConditionOnProperty;

/**
 * @Author xiqiuwei
 * @Date Created in 21:24 2020/5/8
 * @Description
 * @Modified By:
 */
@ConditionOnProperty(name = "user.name",value = "santuer")
public class MyAutoConfiguration {
}
