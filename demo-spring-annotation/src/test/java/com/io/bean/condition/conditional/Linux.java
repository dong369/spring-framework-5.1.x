package com.io.bean.condition.conditional;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class Linux implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		BeanDefinitionRegistry registry = context.getRegistry();
		return Objects.requireNonNull(context.getEnvironment().getProperty("os.name")).contains("Linux");
	}
}
