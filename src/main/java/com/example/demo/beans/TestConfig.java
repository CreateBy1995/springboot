package com.example.demo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-08
 **/
@Configuration
public class TestConfig {
    @Bean
    public TestBean1 testBean1(){
        return new TestBean1();
    }
    @Bean
    public TestBean2 testBean2(){
        return new TestBean2();
    }
}
