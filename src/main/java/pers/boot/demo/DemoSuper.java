package pers.boot.demo;

import pers.boot.demo.beans.MethodBean1;

public interface DemoSuper {
//    @Bean
    default MethodBean1 methodBean1(){
        return new MethodBean1();
    }
}
