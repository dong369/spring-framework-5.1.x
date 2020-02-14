package com.io.main;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since 1.8
 */
public class XmlApplicationTest {
	// 默认不写是类路径下的：bean.xml文件
	// classpath：只会到你的class路径中查找找文件。
	// classpath*：不仅包含class路径，还包括jar文件中（class路径）进行查找。
	// 注意： 用classpath*:需要遍历所有的classpath，所以加载速度是很慢的；因此，在规划的时候，应该尽可能规划好资源文件所在的路径，尽量避免使用classpath*。
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println(context);
	}
}
