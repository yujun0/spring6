package com.powernode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定義註解
 */

/**
 * 標註註解的註解，叫做元註解。@Target註解用來修飾@Component可以出現的位置
 */
// 表示@Component可以出現在 類、屬性上
//@Target(value = {ElementType.TYPE, ElementType.FIELD})
// --------------------------------------------------------
// 表示@Component可以出現在 類上
//@Target(value = {ElementType.TYPE})
// --------------------------------------------------------
// 使用某個註解的時候，如果註解的屬性值是數組，且數組中只有一個元素，大括號可以省略
//@Target(value = {ElementType.TYPE})
@Target(ElementType.TYPE)
// @Retention 也是一個元註解。用來標註@Component最終保留在class文件當中，並且可以被反射機制讀取
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // 定義註解的屬性
    // String是屬性類型、value是屬性名
    String value();

    // 其他的屬性
    // String是屬性類型、name是屬性名
    // String name();

    // 數組類型
    // String[]是屬性類型、names是屬性名
    // String[] names;

    // int[] ages();
    // int age();
}
