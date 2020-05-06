package com.io.bean.importclass;

import com.io.bean.importclass.basa.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println(importingClassMetadata.getClassName());
		if (registry.containsBeanDefinition("com.io.bean.importclass.basa.Red")) {
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Yellow.class);
			registry.registerBeanDefinition("yellow", rootBeanDefinition);
		}
	}
}
