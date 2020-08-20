package com.io.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
@ComponentScan(value = "com.io.bean.circulardependency")
public class CircularDependencyConfig {
}
