package com.io.bean.importclass;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义import导入需要的组件
 *
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class MyImportSelector implements ImportSelector {
	/**
	 * @param importingClassMetadata 当前标注@import注解类的所有注解信息
	 * @return 注册的bean
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("selectImports=>" + importingClassMetadata.getAnnotationTypes());
		// 注意是类的全路径
		return new String[]{"com.io.bean.importclass.basa.Pink", "com.io.bean.importclass.basa.Red"};
	}
}
