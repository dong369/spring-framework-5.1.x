package com.io.config;

import com.io.bean.aop.LogAspects;
import com.io.bean.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author guodd
 * @version 1.0
 * 导入AOP模块=>定义业务类=>定义切面类
 * 通知方法：
 * 1）、前置通知，
 * 2）、后置通知：
 * 3）、返回通知：
 * 4）、异常通知：
 * 5）、环绕通知：
 * 三步：
 * 1）、将业务类和切片类放入到容器，告诉spring哪个是切面类
 * 2）、在切面类上的每一个通知方法上标注注解，告诉spring何时运行
 * 3）、开启spring的aop模式，@EnableAspectJAutoProxy
 * 原理：
 * @see EnableAspectJAutoProxy
 * 1）、流程1创建注册 {@link org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator}的过程
 * 2）、
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
