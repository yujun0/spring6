package com.powernode.client;

import com.powernode.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  需求：目前只知道一個包的名字，掃描這個包下所有的類，當這個類上有@Component註解的時候，實例化該物件，然後放到Map集合中。
 */
public class ComponentScan {
    public static void main(String[] args) {
        // 存放Bean的Map集合。 key存儲beanId。 value存儲Bean。
        Map<String, Object> beanMap = new HashMap<>();
        String packageName = "com.powernode.bean";
        // 開始寫掃描程序。
        // . 這個正則表達式代表任意字符。這裡的"."必須是一個普通的"."字符。不能是正則表達式中的"."
        // 在正則表達式當中怎麼表示一個普通的"."字符呢？使用 \. 正則表達式代表一個普通的 . 字符。
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println("packagePath = " + packagePath);
        // com是在類的根路徑下的一個目錄。
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        System.out.println("url = " + url);
        String path = url.getPath();
        // 獲取一個絕對路徑下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
            try {
//                System.out.println(f.getName());
//                System.out.println(f.getName().split("\\.")[0]);
                String className = packageName + "." + f.getName().split("\\.")[0];
                System.out.println("className = " + className);
                // 通過反射機制解析註解
                Class<?> clazz = Class.forName(className);
                // 判斷類上是否有這個註解
                if (clazz.isAnnotationPresent(Component.class)) {
                    // 獲取註解
                    Component annotation = clazz.getAnnotation(Component.class);
                    String id = annotation.value();
                    // 有這個註解的都要創建物件
                    Object obj = clazz.newInstance();
                    beanMap.put(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("beanMap = " + beanMap);
    }
}