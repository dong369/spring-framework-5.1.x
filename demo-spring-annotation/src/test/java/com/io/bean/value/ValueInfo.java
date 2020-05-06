package com.io.bean.value;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class ValueInfo {
	// 使用@Value进行属性赋值
	// 1、基本数值类型
	// 2、可以写SpEL表单式#{}
	// 3、可以使用${}，取出配置文件中的值（在运行环境变量里面的值）
	// 4、操作系统参数#{systemProperties['os.name']}
	// 5、注入其它bean中的属性#{bookDao.name}
	// 6、注入网址资源
	// 7、注入文件资源

	@Value(value = "张三")
	private String name;
	@Value(value = "#{20 - 2}")
	private Integer age;
	@Value(value = "${nickname}")
	private String nickname;

	public ValueInfo() {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "ValueInfo{" +
			   "name='" + name + '\'' +
			   ", age=" + age +
			   ", nickname='" + nickname + '\'' +
			   '}';
	}
}
