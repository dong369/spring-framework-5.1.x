package com.io.bean.autoinject;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class Y {
	@Autowired
	private X x;

	public Y() {
		System.out.println("Y...Constructor");
	}

	public X getX() {
		return x;
	}

	public void setX(X x) {
		this.x = x;
	}
}
