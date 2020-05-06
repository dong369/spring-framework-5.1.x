package com.io.bean.circulardependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 扩展点的功能是：让应用程序在Spring创建Bean对象前修改BeanDefinition
 * Bean属性配置的类型转换，占位符替换。
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// BeanFactoryPostProcessor只能修改beanDefinitionMap中的信息，不能添加
		GenericBeanDefinition indexDao = (GenericBeanDefinition) beanFactory.getBeanDefinition("indexDao");
		indexDao.setBeanClass(IndexService.class);
	}
}
