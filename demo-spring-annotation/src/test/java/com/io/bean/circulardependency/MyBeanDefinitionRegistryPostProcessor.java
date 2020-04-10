package com.io.bean.circulardependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * 扩展点可以让应用程序注册自定义的BeanDefinition，并且该扩展点在BeanFactoryPostProcessor前执行。
 * 实际上，Mybatis中{@link org.mybatis.spring.mapper.MapperScannerConfigurer}就实现了该方法，在只有接口没有实现类的情况下找到接口方法与sql之间的联系从而生成BeanDefinition并注册。
 *
 * @author guodd
 * @version 1.0
 * @date 2020/4/5
 * @since 1.8
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
