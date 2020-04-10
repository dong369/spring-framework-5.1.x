package com.io.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Aware接口是一个标记接口，表示所有实现该接口的类是会被Spring容器选中，并得到某种通知。
 * 所有该接口的子接口提供固定的接收通知的方法。这样的接口有很多
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 * {@link BeanNameAware}
 */
@Component
public class MyAwareInfo implements
		BeanNameAware, // 获取容器中 Bean 的名称
		BeanFactoryAware, // 获取当前 BeanFactory ，这样可以调用容器的服务
		ApplicationContextAware, // 同上在BeanFactory和ApplicationContext的区别中已明确说明
		EmbeddedValueResolverAware {
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入的ioc：" + applicationContext);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("bean名称：" + name);
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("解析字符串：" + resolver.resolveStringValue("你好，${os.name}，#{20*12}"));
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory);
	}
}
