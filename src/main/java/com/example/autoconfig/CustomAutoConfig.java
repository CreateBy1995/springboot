package com.example.autoconfig;

import com.example.demo.beans.CustomBean;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-11-28
 **/
@Configuration
@ConditionalOnBean(CustomBean.class)
@AutoConfigureOrder(value = Integer.MIN_VALUE)
@AutoConfigureAfter(value = ManagementContextAutoConfiguration.class)
public class CustomAutoConfig {

}
