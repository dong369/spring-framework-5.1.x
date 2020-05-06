package com.io.bean.factory.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 实现接口FactoryBean来定制[实例化]逻辑，工厂Bean
 * FactoryBean在IOC容器的基础上给Bean的实现加上了一个简单工厂模式和装饰模式，我们可以在getObject()方法中灵活配置。
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class MyFactoryBean implements FactoryBean<FactoryBeanInfo> {
	@Override
	public FactoryBeanInfo getObject() {
		System.out.println("crate object bean to factoryBean");
		return new FactoryBeanInfo();
	}

	@Override
	public Class<?> getObjectType() {
		return FactoryBeanInfo.class;
	}

	// 是单例吗？
	@Override
	public boolean isSingleton() {
		return false;
	}
}
