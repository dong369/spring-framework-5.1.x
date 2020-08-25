package com.io.bean.cycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Component
public class PostConstructInfo {
	public PostConstructInfo() {
		System.out.println("constructor...");
	}

	// 对象创建赋值之后调用
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct...");
	}

	// 容器移除对象之前
	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy...");
	}
}
