package com.io.config;

import com.io.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
@Configuration
public class BeanConfig {
	@Bean
	public Person person() {
		return new Person("java", 12);
	}
}
