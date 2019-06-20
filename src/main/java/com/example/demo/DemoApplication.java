package com.example.demo;

import com.example.demo.beans.CustomBean;
import com.example.demo.beans.IBean;
import com.example.demo.beans.MethodBean;
import com.example.demo.beans.MethodBean1;
import com.example.demo.context.CustomContext;
import com.example.demo.event.CustomCommonEvent;
import com.example.demo.event.CustomEvent;
import com.example.demo.imports.ImportByDefault;
import com.example.demo.imports.ImportByDefinitionRegistrar;
import com.example.demo.imports.ImportBySelector;
import com.example.demo.initializers.CustomInitializer;
import com.example.demo.listeners.CustomListener;
import com.example.demo.util.LogUtil;
import com.example.demo.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Import;

@Import(value = {ImportByDefault.class,ImportByDefinitionRegistrar.class,ImportBySelector.class})
//@Conditional(CustomConditional.class)
@SpringBootApplication
//@PropertySource("classpath:config/customFile.properties")
public class DemoApplication implements DemoSuper{
	@Autowired
	private IBean iBean ;
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DemoApplication.class) ;
		// 实现自定义context
		springApplication.setApplicationContextClass(CustomContext.class);
		// 添加自定义listener
		ApplicationListener customListener = new CustomListener() ;
		springApplication.addListeners(customListener);
		// 添加自定义initializer
		ApplicationContextInitializer customInitializer = new CustomInitializer() ;
		springApplication.addInitializers(customInitializer);
		springApplication.run(args);
		// 懒加载的对象
//		SubIBean2 subIBean2 = SpringUtil.getBean("subIBean2",SubIBean2.class) ;
		// 获取在postProcessBeanDefinitionRegistry动态向注册的bean
		CustomBean customBean = SpringUtil.getBean("customBean",CustomBean.class) ;
		MethodBean methodBean = SpringUtil.getBean("methodBean",MethodBean.class) ;
		MethodBean1 methodBean1 = SpringUtil.getBean("methodBean1",MethodBean1.class) ;
		// 发布自定义事件
		CustomCommonEvent customCommonEvent = new CustomCommonEvent(new Object()) ;
		SpringUtil.publishEvent(customCommonEvent);
	}


	/**
	 * 用于测试ConfigurationClassParser的processConfigurationClass()方法在解析类的时候 递归解析内部类
	 */
//	@Component
	private class CustomInnerClass{
		public CustomInnerClass(){
			LogUtil.error("init SubIBean1Depend",this.getClass()) ;
		}
	}
	@Bean
	public MethodBean methodBean(){
		return new MethodBean();
	}
}
