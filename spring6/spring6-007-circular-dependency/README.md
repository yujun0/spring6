源碼分析：
DefaultSingletonBeanRegistry類中有三個比較重要的緩存：
```java
private final Map<String, Object> singletonObjects;                  // 一級緩存
private final Map<String, Object> earlySingletonObjects;             // 二級緩存
private final Map<String, ObjectFactory<?>> singletonFactories;      // 三級緩存
```

這三個緩存都是Map集合。

Map集合的key存儲的都是bean的name（bean id）。

一級緩存存儲的是：單例Bean物件。完整的單例Bean物件，也就是說這個緩存中的Bean物件的屬性都已經賦值了。是一個完整的Bean物件。

二級緩存存儲的是：早期的單例Bean物件。這個緩存中的單例Bean物件的屬性沒有賦值。只是一個早期的實例物件。

三級緩存存儲的是：單例工廠物件。這個里面存儲了大量的「工廠物件」，每一個單例Bean物件都會對應一個單例工廠物件。
                    這個集合中存儲的是，創建該單例物件時對應的那個單例工廠物件。