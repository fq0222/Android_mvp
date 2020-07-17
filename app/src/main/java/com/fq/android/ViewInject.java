package com.fq.android;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)//运行时
@Target(TYPE)//作用于 类
public @interface ViewInject {
    int mainLayoutId() default -1;
}
