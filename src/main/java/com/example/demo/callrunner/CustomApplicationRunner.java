package com.example.demo.callrunner;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
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
