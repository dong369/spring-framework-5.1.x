package com.io.bean.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
public class MyFactoryBean implements FactoryBean<FactoryInfo> {
	@Override
	public FactoryInfo getObject() throws Exception {
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
