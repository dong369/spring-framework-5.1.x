package com.io.bean.autoinject;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
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
