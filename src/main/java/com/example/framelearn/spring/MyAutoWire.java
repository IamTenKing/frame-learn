package com.example.framelearn.spring;

import java.lang.annotation.*;

/**
 * @author jt
 * @date 2020-6-15
 */

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutoWire {
}
