package com.io.main;

import com.io.bean.aop.MathCalculator;
import com.io.bean.autowired.AutowiredService;
import com.io.bean.bean.Person;
import com.io.bean.circulardependency.IndexDao;
import com.io.bean.circulardependency.IndexService;
import com.io.bean.factory.factorybean.FactoryBeanInfo;
import com.io.bean.factory.factorybean.MyFactoryBean;
import com.io.bean.postprocessor.PostProcessorConfig;
import com.io.bean.value.ValueInfo;
import com.io.config.*;
import com.io.mybatis.UserDaoI;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * Spring使命：解决企业级应用开发的复杂性，即简化Java开发。
 * Spring目标：提供一个一站式轻量级应用开发平台。
 * Spring理念：实现解耦。
 * Spring核心：DI、IOC、AOP、MVC。
 * [Java 对象]是普通new的对象，[Spring Bean]是经过spring的生命周期的spring bean，Bean一定是Java对象，但是Java对象不一定是Bean。
 * [实例化]是对象到bean的整个过程；[初始化]是对象new出来后做的事情
 * IOC、AOP、循环依赖(自动注入)、BeanPostProcessor后置处理器、Aware回调
 * spring容器：是spring容器组件的组合，并不是我们理解的单例池，
 * （ApplicationContext、BeanDefinition、BeanFactoryPostProcessor、BeanFactory、beanDefinitionMap、三个缓存对象、后置处理器）
 * 一般使用ApplicationContext，其不但包含了BeanFactory的作用，同时还进行更多的扩展。
 * Class => BeanDefinition => Object(Bean)
 * 扫描 => 解析 => 调用扩展 => 遍历map解析 => new
 * BeanPostProcessor & BeanFactoryPostProcessor 均是后置处理器，都是Spring初始化bean时对外暴露的扩展点。
 * Aware在大多数情况下，我们应该避免使用任何Aware接口，除非我们需要它们。实现这些接口会将代码耦合到Spring框架
 * GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class AnnotationApplicationTest {
	/**
	 * 01、给容器中注册组件：包扫描+组件标注注解(@Bean+包扫描+包含/排除规则)
	 */
	@Test
	public void getCreateBean() {
		// 实例化spring容器对象
		ApplicationContext ioc = new AnnotationConfigApplicationContext(BeanConfig.class);
		// ioc.getBean(Person.class)从spring单例池获取， this.singletonObjects.get(beanName);
		System.out.println(ioc.getBean(Person.class));
		printBeansName(ioc, Person.class);
		printAllBeansName(ioc);
	}

	/**
	 * 02、单实例/多实例
	 */
	@Test
	public void getInstantiation() {
		ApplicationContext ioc = createIoc(InstanceConfig.class);
		System.out.println("=====实例化（单实例/多实例）=====");
		// ioc.getBean("instanceInfo")从spring单例池中获取
		Object instanceInfo01 = ioc.getBean("instanceInfo");
		Object instanceInfo02 = ioc.getBean("instanceInfo");
		System.out.println(instanceInfo01 == instanceInfo02);
	}

	/**
	 * 03、懒加载（单实例bean/多实例bean）
	 */
	@Test
	public void getLazy() {
		ApplicationContext ioc = createIoc(LazyConfig.class);
		System.out.println("=====懒加载（单实例bean）=====");
		Object lazyInfoSingleton01 = ioc.getBean("lazyInfoSingleton");
		Object lazyInfoSingleton02 = ioc.getBean("lazyInfoSingleton");
		System.out.println(lazyInfoSingleton01 == lazyInfoSingleton02);
		// 多实例，每次获取时创建，并初始化。
		System.out.println("=====懒加载（多实例bean）=====");
		Object lazyInfoPrototype01 = ioc.getBean("lazyInfoPrototype");
		Object lazyInfoPrototype02 = ioc.getBean("lazyInfoPrototype");
		System.out.println(lazyInfoPrototype01 == lazyInfoPrototype02);
	}

	/**
	 * 04、给容器中注册组件：@Conditional条件注入，按照一定的条件进行判断，满足条件的才会注册bean
	 * -Dos.name=linux  系统参数
	 * -X 虚拟机参数
	 */
	@Test
	public void getCondition() {
		ApplicationContext ioc = createIoc(ConditionConfig.class);
		printBeansName(ioc, Person.class);
		// 获得环境
		System.out.println("=====获得环境=====");
		Environment environment = ioc.getEnvironment();
		String os = environment.getProperty("os.name");
		System.out.println(os);
	}

	/**
	 * 05、给容器中注册组件：@Import导入bean(简化导入，快速的向容器中导入组件)
	 * {@link org.springframework.context.annotation.Import}
	 * {@link org.springframework.context.annotation.ImportSelector}
	 */
	@Test
	public void getImport() {
		ApplicationContext ioc = createIoc(ImportConfig.class);
		printAllBeansName(ioc);
	}

	/**
	 * 06、FactoryBean给容器中注册组件
	 *
	 * @see org.springframework.beans.factory.BeanFactory，是ioc容器的底层实现接口，是ApplicationContext顶级接口
	 * @see org.springframework.beans.factory.FactoryBean，是spirng提供的工厂bean的一个接口
	 * <p>
	 * {@link SqlSessionFactoryBean}
	 * {@link org.apache.ibatis.session.SqlSessionFactory}
	 * {@link org.mybatis.spring.mapper.MapperFactoryBean}
	 * {@link org.apache.ibatis.binding.MapperProxyFactory}
	 */
	@Test
	public void getFactoryBean() {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(FactoryConfig.class);
		printAllBeansName(ioc);
		System.out.println("=====给容器中注册组件：FactoryBean=====");
		System.out.println(ioc.getBean(MyFactoryBean.class));
		System.out.println(ioc.getBean(FactoryBeanInfo.class));
		// 默认获取工厂bean获取的是getObject创建的对象
		System.out.println(ioc.getBean("myFactoryBean").getClass());
		// 获取工厂Bean本身，我们需要给id前面加一个&
		System.out.println(ioc.getBean("&myFactoryBean").getClass());
	}

	/**
	 * 07、Bean的cycle生命周期（实例化，创建对象（Instantiation） -> 属性赋值(Populate) -> 初始化(Initialization) -> 销毁(Destruction)）
	 * 我们可以自定义初始化方法、销毁方法，容器在bean进行当前生命周期时来调用我们自定义的方法
	 * 构造方法（创建对象）：单实例对象在容器启动时创建对象；多实例对象每次获取时创建对象
	 * 初始化：对象创建完成，并且赋值好，调用初始化方法
	 * 销毁：单实例对象关闭容器时销毁；多实例对象容器不会调用销毁方法
	 * <p>
	 * 方式一、@{@link Bean#initMethod()}、{@link Bean#destroyMethod()}
	 * 方式二、{@link org.springframework.beans.factory.InitializingBean}、{@link org.springframework.beans.factory.DisposableBean}
	 * 方式三、{@link javax.annotation.PostConstruct}、{@link javax.annotation.PreDestroy}
	 * 方式四、{@link org.springframework.beans.factory.config.BeanPostProcessor}
	 * <p>
	 * BeanPostProcessor的执行顺序是在BeanFactoryPostProcessor之后
	 * spring底层使用的
	 */
	@Test
	public void getCycle() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(CycleConfig.class);
		System.out.println("=====容器关闭====");
		ioc.close();
	}

	/**
	 * 08、属性赋值
	 */
	@Test
	public void getPopulate() {
		ApplicationContext ioc = createIoc(PropertyValueConfig.class);
		printAllBeansName(ioc);
		System.out.println("=====属性赋值=====");
		ValueInfo bean = ioc.getBean(ValueInfo.class);
		System.out.println(bean);
	}

	/**
	 * 09、自动装备，自动注入
	 * 方式一、{@link org.springframework.beans.factory.annotation.Autowired}
	 * 方式二、{@link javax.annotation.Resource}，JSR250Java规范
	 * 方式三、{@link javax.inject.Inject}，JSR330Java规范
	 */
	@Test
	public void getAutowired() {
		ApplicationContext ioc = createIoc(AutowiredConfig.class);
		AutowiredService bean = ioc.getBean(AutowiredService.class);
		bean.getAutowiredDao();
	}

	/**
	 * 10、动态的激活和指定环境
	 * -Dspring.profiles.active=test
	 */
	@Test
	public void getProfile() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("test");
		context.register(ProfileConfig.class);
		context.refresh();
		printAllBeansName(context);
	}

	/**
	 * / 11、AOP切面，底层是动态代理
	 * new=>注入属性=>init生命周期初始化方法(@PostConstruct)=>aop=>put singletonObject
	 *
	 * @see org.springframework.context.annotation.EnableAspectJAutoProxy
	 * @see org.springframework.context.annotation.AspectJAutoProxyRegistrar
	 * @see org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
	 * 打断点的技巧：根据类的UML图，从上往下
	 */
	@Test
	public void getAop() {
		ApplicationContext ioc = createIoc(AopConfig.class);
		printAllBeansName(ioc);
		System.out.println("=====AOP切面=====");
		// 不能使用自己创建的对象，只能从容器中获取
		// 此时的对象并不是MathCalculator对象，是MathCalculator$$XXXBySpringCGL
		MathCalculator calculator = ioc.getBean(MathCalculator.class);
		// ioc.getBean(IndexService.class).getIndexDao().log();
		calculator.div(4, 2);
	}

	/**
	 * 12、spring循环依赖
	 * 如何解决循环依赖的问题的？（spring中默认[单例]是执行循环依赖的）
	 * 怎么证明？（通过debug的形式）
	 * 细节源码是？（关闭依赖注入）
	 * 依赖注入是哪一步完成的？（初始化过程中完成的）
	 * indexDao 对象=>注入indexService=>getBean(indexService)，从容器中，拿不到，第三个缓存中拿，new indexService
	 * indexService 对象=>注入indexDao=>getBean(indexDao)，从容器中，拿不到，第三个缓存中拿，new indexDao
	 * 三个map的理解？
	 */
	@Test
	public void getCircularDependency() {
		// 初始化spring容器
		ApplicationContext ioc = new AnnotationConfigApplicationContext(CircularDependencyConfig.class);
		printAllBeansName(ioc);
		IndexService indexService = ioc.getBean(IndexService.class);
		System.out.println(indexService.getIndexDao() == ioc.getBean(IndexDao.class));
	}

	/**
	 * 怎么关闭循环依赖？（修改源码；初始化指定；扩展spring）
	 */
	@Test
	public void getCircularDependencyClose() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(CircularDependencyConfig.class);
		// 设置是否支持循环依赖
		AbstractAutowireCapableBeanFactory beanFactory = (AbstractAutowireCapableBeanFactory) context.getBeanFactory();
		beanFactory.setAllowCircularReferences(false);
		context.refresh();
	}

	/**
	 * 12、回调函数，Bean中直接对容器进行操作，这时候，就可以通过特定的 Aware 接口来完成。
	 * Spring提供Aware接口能让Bean感知Spring容器的存在，即让Bean可以使用Spring容器所提供的资源。
	 */
	@Test
	public void getAware() {
		ApplicationContext ioc = createIoc(AwareConfig.class);
		printAllBeansName(ioc);
	}

	/**
	 * 12、后置处理器
	 * PostProcessor类型接口常用类分为两种，一种是BeanFactoryPostProcessor，另一种是BeanPostProcessor
	 *
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor    关于对象工厂BeanFactory创建完毕的回调处理
	 * @see org.springframework.beans.factory.config.BeanPostProcessor    关于通过对象工厂BeanFactory创建对象前后的回调处理
	 * spring底层大量使用了BeanPostProcessor：bean的赋值、其它组件注入、@Autowired、生命周期的注解等等
	 */
	@Test
	public void getBeanPostProcessor() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(PostProcessorConfig.class);
	}

	// 15、声明式事物

	// 16、扩展（BeanFactoryPostProcessor和BeanDefinitionRegistryPostProcessor）

	// 17、扩展事件（ApplicationListener）

	// 18、mybatis整合
	// SqlSessionFactoryBean & MapperFactoryBean
	// 加入mybatis、spring
	// 原理是通过JDK动态代理为mapper产出代理对象
	// 自己产出的对象如何交给spring管理（@Bean）
	// spring如何把一个类变成bean
	@Test
	public void mybatis() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
		printAllBeansName(context);
		// UserDaoI接口并不能产生对象
		UserDaoI bean = context.getBean(UserDaoI.class);
		System.out.println(bean.getUser());
		SqlSessionFactoryBean sqlSessionFactoryBean;
	}

	// 19、hibernate整合
	// SessionFactory & 声明式事务
	// 加入hibernate、spring
	@Test
	public void hibernate() {

	}

	/**
	 * 创建IOC容器
	 *
	 * @param clazz 配置类
	 * @return 容器对象
	 */
	public ApplicationContext createIoc(Class<?> clazz) {
		System.out.println("======创建IOC容器======");
		System.out.println("创建容器..." + clazz.getName());
		ApplicationContext context = new AnnotationConfigApplicationContext(clazz);
		System.out.println("容器创建完成..." + context.getId());
		return context;
	}

	/**
	 * 打印IOC中所有类型的Bean名称
	 *
	 * @param context 容器对象
	 */
	public void printAllBeansName(ApplicationContext context) {
		System.out.println("======打印IOC中所有类型的Bean名称======");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}

	/**
	 * 打印IOC中指定类型的Bean名称
	 *
	 * @param context 上下文
	 * @param clazz   对象
	 */
	public void printBeansName(ApplicationContext context, Class<?> clazz) {
		System.out.println("======打印IOC中指定类型的Bean名称======");
		for (String bean : context.getBeanNamesForType(clazz)) {
			System.out.println(bean);
		}
	}
}
