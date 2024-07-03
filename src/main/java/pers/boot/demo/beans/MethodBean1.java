package pers.boot.demo.beans;

import pers.boot.demo.util.LogType;
import pers.boot.demo.util.LogUtil;
import lombok.Data;

@Data
public class MethodBean1 {
    private String name;
    private int age ;
    public MethodBean1(){
        LogUtil.print("init MethodBean1",this.getClass(), LogType.ERROR);
    }
}
