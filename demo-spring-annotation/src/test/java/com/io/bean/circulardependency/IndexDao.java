package com.io.bean.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Repository
public class IndexDao {
	@Autowired
	IndexService indexService;

	public IndexDao() {
		System.out.println("constructor...indexDao");
	}

	// 生命周期的初始化的回调方法
	@PostConstruct
	public void init() {
		System.out.println("init....indexDao");
	}

	public void log() {
		System.out.println("log...");
	}
}
