package com.io.config;

import com.io.bean.autowired.AutowiredDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 * <p>
 * 1、@Autowired：自动注入
 * ---1）、默认优先[按照类型]去容器中找对应的组件：applicationContext.getBean(AutowiredDao.class);找到就赋值
 * ---2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找applicationContext.getBean("autowiredDao")
 * ---3）、@Qualifier("autowiredDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 * ---4）、自动装配默认一定要将属性赋值好，没有就会报错；可以使用@Autowired(required=false);
 * ---5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean；也可以继续使用@Qualifier指定需要装配的bean的名字
 * ---6）、使用方式：AutowiredService{ @Autowired AutowiredDao  autowiredDao; }
 * <p>
 * 2、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 * ---1）、@Resource: 可以和@Autowired一样实现自动装配功能；默认是按照[组件名称]进行装配的；没有能支持@Primary功能，没有支持@Autowired（required=false）
 * ---2）、@Inject: 需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能
 * ---3）、@Autowired是Spring定义的；@Resource、@Inject都是java规范
 * ---4）、AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能
 * <p>
 * 3、 @Autowired：参数，构造器，方法，属性都是从容器中获取参数组件的值
 * ---1）、标注在方法位置上：@Bean+方法参数，参数从bean容器中获取，默认不写@Autowired效果一样
 * ---2）、标注在构造器上：如果组件只要一个构造器@Autowired可以省略，参数从ioc容器获取
 * ---3）、放在参数位置
 * <p>
 * 4、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）
 * ---1）、自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware
 * ---2）、把Spring底层一些组件注入到自定义的Bean中；
 * ---3）、xxxAware：功能使用xxxProcessor；ApplicationContextAware ==> ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan(value = {"com.io.bean.autowired"})
public class AutowiredConfig {
	@Primary
	@Bean(value = "autowiredDao01")
	public AutowiredDao autowiredDao() {
		AutowiredDao autowiredDao = new AutowiredDao();
		autowiredDao.setFlag("2");
		return autowiredDao;
	}
}
