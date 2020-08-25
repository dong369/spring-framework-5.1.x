package com.io.bean.condition;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class MyTypeFilter implements TypeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		// 获取当前类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取正在扫描类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取类的资源
		Resource resource = metadataReader.getResource();
		String s = metadataReaderFactory.toString();
		// System.out.println("TypeFilter=>" + classMetadata.getClassName());
		return classMetadata.getClassName().contains("er");
	}
}
