package com.io.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * 在所有bean定义信息将要被加载，bean实例还未创建
 * 扩展点可以让应用程序注册自定义的BeanDefinition，并且该扩展点在BeanFactoryPostProcessor前执行。
 * 实际上，Mybatis中{@link org.mybatis.spring.mapper.MapperScannerConfigurer}就实现了该方法，在只有接口没有实现类的情况下找到接口方法与sql之间的联系从而生成BeanDefinition并注册。
 *
 * @author guodd
 * @version 1.0
 * @since 1.8
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	// BeanDefinitionRegistry里面保存了每一个bean的定义信息
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		int count = registry.getBeanDefinitionCount();
		// RootBeanDefinition definition = new RootBeanDefinition(PostProcessorInfo.class);
		AbstractBeanDefinition definition = BeanDefinitionBuilder.rootBeanDefinition(PostProcessorInfo.class).getBeanDefinition();
		registry.registerBeanDefinition("bb", definition);
		System.out.println("MyBeanDefinitionRegistryPostProcessor registry" + count);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int count = beanFactory.getBeanDefinitionCount();
		System.out.println("MyBeanDefinitionRegistryPostProcessor beanFactory" + count);
	}
}
