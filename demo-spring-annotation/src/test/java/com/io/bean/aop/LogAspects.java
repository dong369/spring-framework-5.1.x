package com.io.bean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Project - 日志切面类
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Aspect
public class LogAspects {
	// 抽取切入表达式
	// 本类引用：point()
	// 其他切面引用：com.io.bean.aop.LogAspects.point()
	@Pointcut("execution(public * com.io.bean..*Calculator.*(..))")
	public void point() {
	}

	@Before("point()")
	public void logStart(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "方法，开始...before" + Arrays.toString(joinPoint.getArgs()));
	}

	@After("com.io.bean.aop.LogAspects.point()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "方法，结束...after");
	}

	@AfterReturning(value = "point()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + "方法，正常返回...returning" + result);
	}

	@AfterThrowing(value = "point()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(joinPoint.getSignature().getName() + "方法，异常...throwing" + exception);
	}
}
