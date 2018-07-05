package com.ut.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE,ElementType.METHOD})
@Inherited
public @interface ServiceComponent {

    /**
     * 是否作会话验证
     *
     * @return 否作会话验证
     */
    boolean session() default true;
}
