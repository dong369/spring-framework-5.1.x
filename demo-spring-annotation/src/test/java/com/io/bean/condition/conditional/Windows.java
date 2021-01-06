package com.io.bean.condition.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * @author guodd
 * @version 1.0
 * @since JDK1.8
 */
public class Windows implements Condition {
	@Override
	public boolean matches(ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
		return Objects.requireNonNull(context.getEnvironment().getProperty("os.name")).contains("Windows 10");
	}
}
