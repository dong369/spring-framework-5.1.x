package com.io.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 * 一、步骤
 * 1）、导入依赖
 * 2）、配置数据源
 * 3）、开启基于注解的事物
 * 4）、配置事物管理器
 * 二、原理
 */
@Configuration
@ComponentScan(value = {"com.io.bean.tx"})
@EnableTransactionManagement
public class TxConfig {
	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource source = new ComboPooledDataSource();
		source.setUser("root");
		source.setPassword("passw0rd");
		source.setDriverClass("com.mysql.jdbc.Driver");
		source.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		return source;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() throws Exception {
		// DataSource dataSource
		// jdbcTemplate.setDataSource(dataSource);
		// spring对@Configuration类做了特殊处理，多次调用只是从容器中找组件
		return new JdbcTemplate(dataSource());
	}

	// 配置事物管理器
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
