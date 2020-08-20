package com.io.bean.bean;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class Person {
	/**
	 * 属性描述：name
	 */
	private String name;

	/**
	 * 属性描述：age
	 */
	private Integer age;

	public Person() {
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
