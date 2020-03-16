package com.io.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Component
public class MyAwareInfo implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
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
}
