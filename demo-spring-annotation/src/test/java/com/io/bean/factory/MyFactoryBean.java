package com.io.bean.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * 实现接口FactoryBean来定制实例化逻辑
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
public class MyFactoryBean implements FactoryBean<FactoryInfo> {
	@Override
	public FactoryInfo getObject() {
		return new FactoryInfo();
	}

	@Override
	public Class<?> getObjectType() {
		return FactoryInfo.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
