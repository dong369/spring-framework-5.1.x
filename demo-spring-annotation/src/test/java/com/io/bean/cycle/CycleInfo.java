package com.io.bean.cycle;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class CycleInfo {
	/**
	 * 属性描述：name
	 */
	private String name;

	public CycleInfo() {
		System.out.println("constructor...");
	}

	public CycleInfo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		System.out.println("init...");
	}

	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public String toString() {
		return "CycleInfo{" +
			   "name='" + name + '\'' +
			   '}';
	}
}
