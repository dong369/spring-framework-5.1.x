package com.io.config;

import com.io.bean.bean.Person;
import com.io.bean.condition.conditional.Linux;
import com.io.bean.condition.conditional.Windows;
import com.io.bean.mvc.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
public class ConditionConfig {
	@Bean("bill")
	@Conditional(Windows.class)
	public Person person01() {
		return new Person("Bill", 55);
	}

	@Bean("linus")
	@Conditional(Linux.class)
	public Person person02() {
		return new Person("Linus", 55);
	}

	// @ConditionalOnBean，当给定的在bean存在时,则实例化当前Bean
	@Bean("guo")
	@ConditionalOnBean(value = {Person.class})
	public Person person03() {
		return new Person("guo", 55);
	}

	// @ConditionalOnMissingBean，当给定的在bean不存在时,则实例化当前Bean
	@Bean("dong")
	@ConditionalOnMissingBean(value = {UserService.class})
	public Person person04() {
		return new Person("dong", 22);
	}

	// @ConditionalOnClass，当给定的类名在类路径上存在，则实例化当前Bean
	@Bean
	@ConditionalOnClass(value = {Windows.class})
	public Person person05() {
		return new Person("java", 26);
	}

	@Bean
	@ConditionalOnMissingClass(value = {"com.io.bean.condition.conditional.Person02"})
	public Person person06() {
		return new Person("person06", 12);
	}
}
