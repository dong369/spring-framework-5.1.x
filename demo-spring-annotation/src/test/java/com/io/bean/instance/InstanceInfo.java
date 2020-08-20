package com.io.bean.instance;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class InstanceInfo {
	/**
	 * 属性描述：name
	 */
	private String name;

	public InstanceInfo() {
		System.out.println("constructor...instanceInfo");
	}

	public InstanceInfo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "InstanceInfo{" +
				"name='" + name + '\'' +
				'}';
	}
}
