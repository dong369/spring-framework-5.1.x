/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.type.filter;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * Base interface for type filters using a
 * {@link org.springframework.core.type.classreading.MetadataReader}.
 *
 * @author Costin Leau
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @since 2.5
 */
@FunctionalInterface
public interface TypeFilter {

	/**
	 * Determine whether this filter matches for the class described by
	 * the given metadata.
	 *
	 * @param metadataReader        the metadata reader for the target class（获取到的当前正在扫描的类的信息）
	 * @param metadataReaderFactory a factory for obtaining metadata readers（获取元数据阅读器的工厂）
	 *                              for other classes (such as superclasses and interfaces)（用于其他类（例如超类和接口））
	 * @return whether this filter matches（此过滤器是否匹配）
	 * @throws IOException in case of I/O failure when reading metadata（如果在读取元数据时I / O失败）
	 */
	boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException;

}
