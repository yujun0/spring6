package org.myspringframework.core;

/**
 * MySpring框架應用上下文介面。
 **/
public interface ApplicationContext {
    /**
     * 根據bean的名稱獲取對應的bean物件。
     * @param beanName myspring配置文件中bean標籤的id。
     * @return 對應的單例bean物件。
     */
    Object getBean(String beanName);
}