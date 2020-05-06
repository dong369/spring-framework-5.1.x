package com.io.bean.autowired;

import org.springframework.stereotype.Component;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
@Component
public class Boss {
	private Car car;

	public Boss(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
