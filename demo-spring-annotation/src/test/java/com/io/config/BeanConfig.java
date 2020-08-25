package com.io.config;

import com.io.bean.bean.Person;
import com.io.bean.condition.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration   // 告诉spring这是一个配置类，配置类==bean.xml配置文件
@ComponentScan(value = {"com.io.bean.mvc"},  // 配置包扫描，spring boot默认扫描@SpringBootApplication主类的同级包和子包。
		useDefaultFilters = false,
		// 排除指定类
		// excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
		// 包含指定类
		includeFilters = {
				// @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class}),
				// @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {UserService.class})
				@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
		}
)
public class BeanConfig {
	// 给容器注册一个bean，类型是返回值类型，id默认是方法名称
	@Bean(value = {"person01"})
	public Person person() {
		return new Person("guo", 1);
	}
}
