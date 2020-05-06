package com.io.config;

import com.io.bean.value.ValueInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 属性赋值配置
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
@PropertySource(value = {"classpath:/valueInfo.properties"})
public class PropertyValueConfig {
	@Bean
	public ValueInfo valueInfo() {
		return new ValueInfo();
	}
}
