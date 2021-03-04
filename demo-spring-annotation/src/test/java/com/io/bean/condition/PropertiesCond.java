package com.io.bean.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * The class/interface 控制配置类是否生效
 *
 * @author guodd
 * @version 1.0 use jdk 1.8
 */
@Configuration
@ConditionalOnProperty(prefix = "info", name = "enable", havingValue = "true")
public class PropertiesCond {
}
