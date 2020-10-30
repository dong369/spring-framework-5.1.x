package com.io.bean.listener;

import org.springframework.context.ApplicationEvent;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
public class MyApplicationEvent extends ApplicationEvent {

	private static final long serialVersionUID = -213229384189934813L;
	private String msg;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public MyApplicationEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
