package com.io.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/3 时间:14:50
 * @since JDK1.8
 */
@Configuration
@PropertySource(value = "classpath:/db.properties")
//@Profile("test")
public class ProfileConfig implements EmbeddedValueResolverAware {
	@Value("${db.name}")
	private String user;

	private StringValueResolver resolver;

	private String driver;

	@Bean
	@Profile("dev")
	public DataSource dataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("mysql:jdbc:///test");
		dataSource.setDriverClass(driver);
		return dataSource;
	}

	@Bean
	@Profile("test")
	public DataSource dataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("mysql:jdbc:///test");
		dataSource.setDriverClass(driver);
		return dataSource;
	}


	@Bean
	@Profile("prod")
	public DataSource dataSourceProd(@Value("${db.password}") String password) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("mysql:jdbc:///test");
		dataSource.setDriverClass(driver);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
		driver = resolver.resolveStringValue("${db.driver}");
	}
}
