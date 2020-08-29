package com.io.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * The class/interface BeanFactory的后置处理器
 * 在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容
 * 所以的bean定义已经保存加载到BeanFactory，但是bean实例还未创建
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int count = beanFactory.getBeanDefinitionCount();
		System.out.println("MyBeanFactoryProcessor beanFactory" + count);
	}
}
