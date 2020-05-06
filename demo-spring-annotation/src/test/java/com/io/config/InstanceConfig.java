package com.io.config;

import com.io.bean.instance.InstanceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
public class InstanceConfig {
	@Bean
	@Scope(value = "prototype")  // 默认是单实例：singleton
	public InstanceInfo instanceInfo() {
		System.out.println("创建bean...");
		return new InstanceInfo();
	}
}
