package com.powernode.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws Exception {
        /*
        需求：
            假設你現在已知以下信息：
                1. 有這樣一個類，類名叫做：com.powernode.reflect.User
                2. 這個類符合javabean規範。屬性私有化，對外提供公開的setter和getter方法。
                3. 你還知道這個類當中有一個屬性，屬性的名字叫做 age
                4. 並且你還知道age屬性的類型是int類型。
            請使用反射機制調用set方法，給User物件的age屬性賦值。
         */
        String className = "com.powernode.reflect.User";
        String agePropertyName = "age";
        String namePropertyName = "name";

        // 通過反射機制調用setAge(int)方法

        // 獲取類
        Class<?> clazz = Class.forName(className);
        // 獲取方法名
        String setAgeMethodName = "set" + agePropertyName.toUpperCase().charAt(0) + agePropertyName.substring(1);
        String setNameMethodName = "set" + namePropertyName.toUpperCase().charAt(0) + namePropertyName.substring(1);
        // 根據屬性名獲取屬性類型
        Field ageField = clazz.getDeclaredField(agePropertyName);
        Field nameField = clazz.getDeclaredField(namePropertyName);
        // 獲取方法
        Method setAgeMethod = clazz.getDeclaredMethod(setAgeMethodName, ageField.getType());
        Method setNameMethod = clazz.getDeclaredMethod(setNameMethodName, nameField.getType());
        // 準備物件
        Object obj = clazz.newInstance();
        // 調用方法
        setAgeMethod.invoke(obj, 25);
        setNameMethod.invoke(obj, "Lisa");
        System.out.println(obj);
    }
    
}