package pers.boot.demo.beans;

import pers.boot.demo.util.LogType;
import pers.boot.demo.util.LogUtil;
import lombok.Data;

@Data
public class MethodBean {
    private String name;
    private int age ;
    public MethodBean(){
        LogUtil.print("init MethodBean",this.getClass(), LogType.ERROR);
    }
}
