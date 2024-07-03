package pers.boot.demo.beans;

import pers.boot.demo.util.LogType;
import pers.boot.demo.util.LogUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SubIBean2 implements IBean {
    public SubIBean2() {
        LogUtil.print("init SubIBean2",this.getClass(), LogType.ERROR);
    }
}
