package com.io.config;

import com.io.bean.base.Person;
import com.io.bean.condition.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
// 配置类==xml配置文件
@Configuration   // 告诉spring这是一个配置类
@ComponentScan(value = {"com.io"},
		useDefaultFilters = false,
		// 排除指定的
		// excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
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
