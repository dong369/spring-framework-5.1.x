package com.io.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The class/interface
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
@Configuration
@ComponentScan(basePackages = "com.io.bean.listener")
public class ApplicationListenerConfig {
}
