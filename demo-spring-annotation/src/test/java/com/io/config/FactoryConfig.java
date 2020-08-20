package com.io.config;

import com.io.bean.factory.factorybean.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
public class FactoryConfig {

	@Bean
	public MyFactoryBean myFactoryBean() {
		return new MyFactoryBean();
	}
}
