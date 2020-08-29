package com.io.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Aware接口是一个标记接口，表示所有实现该接口的类是会被Spring容器选中，并得到某种通知。
 * 所有该接口的子接口提供固定的接收通知的方法。这样的接口有很多
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 * {@link BeanNameAware}
 */
@Component
public class MyAwareInfo implements
		ApplicationContextAware, // Bean被初始化后，会被注入到ApplicationContext，能获取Application Context调用容器的服务
		BeanFactoryAware, // 获取当前BeanFactory，能获取Bean Factory调用容器的服务
		ResourceLoaderAware, // 获取资源加载器，以获取外部资源文件
		EmbeddedValueResolverAware, // 读取配置文件内容
		EnvironmentAware, // 能获取当前容器的环境属性信息
		MessageSourceAware, // 	能获取国际化文本信息,Message Source的相关文本信息
		BeanNameAware, // 获取容器中Bean的名称
		ApplicationEventPublisherAware, // 应用事件发布器，可以用来发布事件
		BeanClassLoaderAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
		System.out.println("ApplicationContextAware传入的ioc：" + Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryAware：" + beanFactory.getBean(MyAwareInfo.class));
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		Resource resource = resourceLoader.getResource("classpath:db.properties");
		try {
			InputStream inputStream = resource.getInputStream();
			System.out.println("ResourceLoaderAware：" + inputStream.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("EmbeddedValueResolverAware解析字符串：" + resolver.resolveStringValue("你好，${os.name}，#{20*12}"));
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println(environment.getProperty("os.name"));
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("setMessageSource=>" + messageSource);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("bean名称：" + name);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {

	}
}
