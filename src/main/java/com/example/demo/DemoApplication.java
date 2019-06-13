package com.example.demo;

import com.example.demo.conditionals.CustomConditional;
import com.example.demo.context.CustomContext;
import com.example.demo.initializers.CustomInitializer;
import com.example.demo.listeners.CustomListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Conditional;

@Conditional(CustomConditional.class)
@SpringBootApplication
public class DemoApplication {

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
	}

}
