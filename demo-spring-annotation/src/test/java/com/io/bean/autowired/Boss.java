package com.io.bean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 * 默认情况IOC容器调用无参构造器创建对象，再进行初始化赋值
 */
@Component
public class Boss {
	// @Autowired
	private Car car;

	public Boss() {
	}

	// @Autowired
	public Boss(@Autowired Car car) {
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	// @Autowired
	// 标注在方法上，spring容器创建当前对象时会调用该方法，完成赋值
	// 方法使用的参数从IOC容器中获取
	public void setCar(Car car) {
		this.car = car;
	}
}
