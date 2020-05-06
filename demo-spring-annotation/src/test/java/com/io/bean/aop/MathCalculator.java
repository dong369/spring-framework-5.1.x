package com.io.bean.aop;

/**
 * Project - 业务逻辑类
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class MathCalculator {
	public int div(int x, int y) {
		System.out.println("mathCalculator...div");
		return x / y;
	}
}
