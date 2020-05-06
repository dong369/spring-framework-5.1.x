package com.io.bean.autoinject;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class X {
	@Autowired
	private Y y;

	public X() {
		System.out.println("X...Constructor");
	}

	public Y getY() {
		return y;
	}

	public void setY(Y y) {
		this.y = y;
	}
}
