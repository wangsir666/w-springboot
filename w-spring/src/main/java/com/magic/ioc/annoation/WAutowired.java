package com.magic.ioc.annoation;

import java.lang.annotation.*;

/**
 * @Auther: wjx
 * @Date: 2020/10/31 15:57
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WAutowired {
}
