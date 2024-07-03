package pers.boot.demo.beans;

import pers.boot.demo.annotation.CustomAnnotation;
import pers.boot.demo.annotation.CustomAnnotation2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-11-26
 **/
@Component
public class ConditionBean{
    @Autowired
    private DBean dBean;
    @CustomAnnotation2
    @CustomAnnotation
    public void hello(){
        System.out.println("ConditionBean hello");
    }

    @CustomAnnotation
    public  void  hi(){
        System.out.println("ConditionBean hi");
    }
    public  void  ok(){
        System.out.println("ConditionBean ok");
    }
    private  void  ok1(){
        System.out.println("ConditionBean ok1");
    }

}
