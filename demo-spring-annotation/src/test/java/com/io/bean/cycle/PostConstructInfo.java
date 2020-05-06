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

	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct...");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy...");
	}
}
