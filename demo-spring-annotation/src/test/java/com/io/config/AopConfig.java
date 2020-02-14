package com.io.config;

import com.io.bean.aop.LogAspects;
import com.io.bean.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 导入AOP模块=>定义业务类=>定义切面类
 * 通知方法：前置通知，后置通知，返回通知，异常通知，环绕通知
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}

	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
}
