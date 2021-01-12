package com.magic.ioc.annoation;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface WService {

    String value() default "";
}
