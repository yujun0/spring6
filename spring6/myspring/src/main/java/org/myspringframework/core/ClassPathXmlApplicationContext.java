package org.myspringframework.core;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger log = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);
    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getBean(String beanId) {
        return singletonObjects.get(beanId);
    }

    /**
     * 解析myspring的配置文件，然後初始化所有的Bean物件。
     *
     * @param resource spring配置文件的路徑。注意：使用ClassPathXmlApplicationContext，配置文件應當放到類路徑下。
     */
    public ClassPathXmlApplicationContext(String resource) {
        try {
            // 解析myspring.xml文件，然後實例化Bean，將Bean存放到singletonObjects集合當中。
            // 這是dom4j解析XML文件的核心物件。
            SAXReader reader = new SAXReader();
            // 獲取一個輸入流，指向配置文件
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
            // 讀文件
            Document document = reader.read(inputStream);
            // 獲取所有的bean標籤
            List<Node> nodes = document.selectNodes("//bean");
            // 遍歷bean標籤
            nodes.forEach(node -> {
                try {
                    // 向下轉型的目的是為了使用Element介面裡更加豐富的方法。
                    Element beanElt = (Element) node;
                    // 獲取id屬性
                    String id = beanElt.attributeValue("id");
                    // 獲取class屬性
                    String className = beanElt.attributeValue("class");
                    log.info("beanId: {}", id);
                    log.info("beanClassName: {}", className);
                    // 通過反射機制創建物件，將其放到Map集合中，提前曝光。
                    // 獲取Class
                    Class<?> clazz = Class.forName(className);
                    // 獲取無參數構造方法
                    Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
                    // 調用無參數構造方法實例化Bean
                    Object bean = defaultConstructor.newInstance();
                    // 將Bean曝光，加入Map集合
                    singletonObjects.put(id, bean);
                    // 記錄日誌
                    log.info("singletonObjects: {}", singletonObjects);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再次重新把所有的bean標籤遍歷一次，這一次主要是給物件的屬性賦值。
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    // 獲取id
                    String id = beanElt.attributeValue("id");
                    // 獲取className
                    String className = beanElt.attributeValue("class");
                    // 獲取Class
                    Class<?> clazz = Class.forName(className);
                    // 獲取該bean標籤下所有的屬性property標籤
                    List<Element> properties = beanElt.elements("property");
                    // 遍歷所有的屬性標籤
                    properties.forEach(property -> {
                        try {
                            // 獲取屬性名
                            String propertyName = property.attributeValue("name");
                            // 獲取屬性類型
                            Field field = clazz.getDeclaredField(propertyName);
                            log.info("屬性名： {}", propertyName);
                            // 獲取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            // 獲取set方法
                            Method setMethod = clazz.getDeclaredMethod(setMethodName, field.getType());
                            // 獲取具體的值
                            String value = property.attributeValue("value");
                            Object actualValue; // 真值
                            String ref = property.attributeValue("ref");
                            if (value != null) {
                                // 說明這個值是簡單類型
                                // 調用set方法(set方法沒有返回值)
                                // 我們myspring框架聲明一下：我們只支持這些類型為簡單類型
                                // byte short int long float double boolean char
                                // Byte Short Integer Long Float Double Boolean Character
                                // String
                                // 獲取屬性類型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte" -> actualValue = Byte.parseByte(value);
                                    case "short" -> actualValue = Short.parseShort(value);
                                    case "int" -> actualValue = Integer.parseInt(value);
                                    case "long" -> actualValue = Long.parseLong(value);
                                    case "float" -> actualValue = Float.parseFloat(value);
                                    case "double" -> actualValue = Double.parseDouble(value);
                                    case "boolean" -> actualValue = Boolean.parseBoolean(value);
                                    case "char" -> actualValue = value.charAt(0);
                                    case "Byte" -> actualValue = Byte.parseByte(value);
                                    case "Short" -> actualValue = Short.parseShort(value);
                                    case "Integer" -> actualValue = Integer.parseInt(value);
                                    case "Long" -> actualValue = Long.parseLong(value);
                                    case "Float" -> actualValue = Float.parseFloat(value);
                                    case "Double" -> actualValue = Double.parseDouble(value);
                                    case "Boolean" -> actualValue = Boolean.parseBoolean(value);
                                    case "Character" -> actualValue = Character.valueOf(value.charAt(0));
                                    case "String" -> actualValue = value;
                                    default -> actualValue = value;
                                }
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            }
                            if (ref != null) {
                                // 說明這個值是非簡單類型
                                // 調用set方法(set方法沒有返回值)
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
