package com.io.config;

import com.io.bean.cycle.CycleInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 * 对象创建：单实例启动时创建；多实例获取时创建对象。
 * 对象赋值：
 * 对象初始化：
 * 对象销毁：单实例关闭容器时销毁；多实例不会管理bean。
 * 方式一：指定初始化和销毁方法（init、destroy）。
 * 方式二：
 */
@Configuration
@ComponentScan(value = "com.io.bean.cycle")
public class CycleConfig {
	// @Scope(value = "prototype")
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public CycleInfo cycleInfo() {
		return new CycleInfo();
	}
}
