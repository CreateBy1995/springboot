package pers.boot.demo.callrunner;

import pers.boot.demo.util.LogType;
import pers.boot.demo.util.LogUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {
    /**
     * 该方法在SpringBoot启动结束后被回调
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            LogUtil.print("参数为------"+args[i],this.getClass(), LogType.WARN);
        }
    }
}
