package com.io.bean.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("接收事件：" + event.getMsg());
	}
}
