package com.io.bean.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Service
public class IndexService {
	@Autowired
	IndexDao indexDao;

	public IndexService() {
		System.out.println("constructor...indexService");
	}

	// 生命周期初始化回调方法
	@PostConstruct
	public void init() {
		System.out.println("init....indexService");
	}

	public IndexDao getIndexDao() {
		return indexDao;
	}
}
