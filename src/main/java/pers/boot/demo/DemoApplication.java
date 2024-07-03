package pers.boot.demo;

import pers.boot.autoconfig.CustomAutoConfig;
import pers.boot.demo.beans.ConditionBean;
import pers.boot.demo.beans.CustomAutconfig2;
import pers.boot.demo.beans.CustomBean;
import pers.boot.demo.beans.IBean;
import pers.boot.demo.beans.MethodBean;
import pers.boot.demo.beans.MethodBean1;
import pers.boot.demo.conditionals.CustomConditional;
import pers.boot.demo.context.CustomContext;
import pers.boot.demo.event.CustomCommonEvent;
import pers.boot.demo.imports.ImportByDefault;
import pers.boot.demo.imports.ImportByDefinitionRegistrar;
import pers.boot.demo.imports.ImportBySelector;
import pers.boot.demo.initializers.CustomInitializer;
import pers.boot.demo.listeners.CustomListener;
import pers.boot.demo.util.LogUtil;
import pers.boot.demo.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Import(value = {ImportByDefault.class, ImportByDefinitionRegistrar.class, ImportBySelector.class})
@Conditional(CustomConditional.class)
@SpringBootApplication
@PropertySource("classpath:config/customFile.properties")
public class DemoApplication implements DemoSuper {
    @Autowired
    private IBean iBean;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        // 实现自定义context
        springApplication.setApplicationContextClass(CustomContext.class);
        // 添加自定义listener
        ApplicationListener customListener = new CustomListener();
        springApplication.addListeners(customListener);
        // 添加自定义initializer
        ApplicationContextInitializer customInitializer = new CustomInitializer();
        springApplication.addInitializers(customInitializer);
        springApplication.run(args);
        // 懒加载的对象
//		SubIBean2 subIBean2 = SpringUtil.getBean("subIBean2",SubIBean2.class) ;
        // 获取在postProcessBeanDefinitionRegistry动态向注册的bean
        CustomBean customBean = SpringUtil.getBean("customBean", CustomBean.class);
        MethodBean methodBean = SpringUtil.getBean("methodBean", MethodBean.class);
        MethodBean1 methodBean1 = SpringUtil.getBean("methodBean1", MethodBean1.class);
        ConditionBean conditionBean = SpringUtil.getBean(ConditionBean.class);
        conditionBean.hello();
//        conditionBean.hello();

        CustomAutconfig2 customAutconfig2 = SpringUtil.getBean(CustomAutconfig2.class);
        System.out.println(customAutconfig2);
        CustomAutoConfig customAutoConfig = SpringUtil.getBean(CustomAutoConfig.class);
        System.out.println(customAutoConfig);
        // 发布自定义事件
        CustomCommonEvent customCommonEvent = new CustomCommonEvent(new Object());
        SpringUtil.publishEvent(customCommonEvent);


    }

    /**
     * 用于测试ConfigurationClassParser的processConfigurationClass()方法在解析类的时候 递归解析内部类
     */
    @Component
    private class CustomInnerClass {
        public CustomInnerClass() {
            LogUtil.error("init SubIBean1Depend", this.getClass());
        }
    }

    @Bean
    public MethodBean methodBean() {
        return new MethodBean();
    }

    @Override
    @Bean
    public MethodBean1 methodBean1() {
        MethodBean1 methodBean1 = new MethodBean1();
        methodBean1.setAge(232);
        return methodBean1;
    }


}
