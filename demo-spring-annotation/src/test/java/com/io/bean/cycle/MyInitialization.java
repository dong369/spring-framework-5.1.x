package com.io.bean.cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Component
public class MyInitialization implements InitializingBean, DisposableBean {
	@Override
	public void destroy() {
		System.out.println("Initialization...destroy");
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("Initialization...afterPropertiesSet");
	}
}
