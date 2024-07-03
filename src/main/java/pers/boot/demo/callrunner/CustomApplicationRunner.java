package pers.boot.demo.callrunner;

import pers.boot.demo.util.LogType;
import pers.boot.demo.util.LogUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogUtil.print(args.toString(),this.getClass(), LogType.WARN);
    }
}
