package com.zja.rest.annotation;

import java.lang.annotation.*;

/**
 * @author dingchw
 * @date 2019/4/1.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistPathVariable {
    String value() default "";
}