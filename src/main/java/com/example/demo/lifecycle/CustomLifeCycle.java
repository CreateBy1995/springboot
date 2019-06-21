package com.example.demo.lifecycle;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class CustomLifeCycle implements SmartLifecycle {
    private boolean isRunning = false;
    /**
     * 该方法在SpringBoot启动的时候被回调
     */
    @Override
    public void start() {
        isRunning = true ;
        LogUtil.print("在SpringBoot 启动的时候做一些事情",this.getClass(), LogType.ERROR);
    }

    @Override
    public void stop() {

    }

    /**
     * 该方法在SpringBoot关闭的时候被回调
     * 如果isRunning返回true,则本方法会被调用
     * 业务逻辑处理结束后要调用 callback.run()。
     * 否则在程序退出时，SpringBoot的DefaultLifecycleProcessor会认为stop()没有完成，程序会一直卡着结束不了
     * 等待一定时间 默认超时时间30000ms 后才会自动结束。
     */

    @Override
    public void stop(Runnable callback) {
        LogUtil.print("在SpringBoot 关闭的时候做一些事情",this.getClass(), LogType.ERROR);
        callback.run();
    }

    /**
     * 在调用start()方法前会先判断 返回值 如果为false 才会调用
     * 在调用stop()方法前会先判断 返回值 如果为true 才会调用
     * @return
     */
    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
