package com.io.bean.aop;

/**
 * Project - 业务逻辑类
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
public class MathCalculator {
	public int div(int x, int y) {
		System.out.println("mathCalculator...div");
		return x / y;
	}
}
