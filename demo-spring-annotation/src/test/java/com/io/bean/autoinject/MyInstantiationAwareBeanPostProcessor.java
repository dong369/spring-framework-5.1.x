package com.io.bean.autoinject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Project - 扩展点
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return false;
	}
}
