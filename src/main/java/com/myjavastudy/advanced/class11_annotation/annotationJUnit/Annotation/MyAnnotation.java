package com.myjavastudy.advanced.class11_annotation.annotationJUnit.Annotation;

public @interface MyAnnotation {
    //当没有传进value时，默认值为hello
    String value() default "hello";
}
