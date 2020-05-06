package com.io.bean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Service
public class AutowiredService {
	@Qualifier(value = "autowiredDao")
	@Autowired(required = false)
	// @Resource
	// @Inject
	private AutowiredDao autowiredDao01;

	// @Autowired
	public AutowiredService(AutowiredDao autowiredDao) {
		this.autowiredDao01 = autowiredDao;
	}

	public AutowiredDao getAutowiredDao01() {
		return autowiredDao01;
	}

	// @Autowired
	// 标注在方法上，spring容器创建当前对象就会调用该方法，完成赋值
	// 方法中使用的参数：autowiredDao01从ioc容器中获取
	public void setAutowiredDao01(AutowiredDao autowiredDao01) {
		this.autowiredDao01 = autowiredDao01;
	}

	public void getAutowiredDao() {
		System.out.println(autowiredDao01);
	}
}
