package com.example.demo;

import com.example.demo.beans.MethodBean1;

public interface DemoSuper {
//    @Bean
    default MethodBean1 methodBean1(){
        return new MethodBean1();
    }
}
