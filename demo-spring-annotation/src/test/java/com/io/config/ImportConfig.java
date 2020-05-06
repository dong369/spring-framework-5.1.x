package com.io.config;

import com.io.bean.importclass.ImportInfo;
import com.io.bean.importclass.MyImportBeanDefinitionRegistrar;
import com.io.bean.importclass.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
// 导入组件，id默认是组件的全类名
@Import(value = {ImportInfo.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {
}
