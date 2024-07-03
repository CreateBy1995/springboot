package pers.boot.demo;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-04
 **/
public class NoContructBean {
    public NoContructBean(String name){
        this.name = name;
    }
    private String name;
    public String getName(){
        return name;
    }
}
