package com.io.config;

import com.io.bean.lazy.LazyInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Configuration
public class LazyConfig {
	// 懒加载：单实例bean默认启动ioc容器时创建对象，懒加载时容器启动时不创建对象，第一次获取时创建，并初始化。
	@Bean
	@Lazy
	public LazyInfo lazyInfoSingleton() {
		System.out.println("singleton注册容器对象...");
		return new LazyInfo();
	}

	// 懒加载：多实例bean默认启动ioc容器时不创建对象，每次获取时创建，并初始化。
	@Bean
	@Lazy
	@Scope(value = "prototype")
	public LazyInfo lazyInfoPrototype() {
		System.out.println("prototype注册容器对象...");
		return new LazyInfo();
	}
}
