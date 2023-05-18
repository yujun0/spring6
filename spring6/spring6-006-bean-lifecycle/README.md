# Bean的生命週期
## Bean的生命週期-五步：
1. 實例化Bean
2. Bean屬性賦值
3. 初始化Bean
4. 使用Bean
5. 銷毀Bean
## Bean生命週期-七步：
比五部多的那兩部在初始化Bean的前和後

1. 實例化Bean
2. Bean屬性賦值
3. 執行 **Bean後處理器** 的before方法
4. 初始化Bean
5. 執行 **Bean後處理器** 的after方法
6. 使用Bean
7. 銷毀Bean

## Bean生命週期-十步
比七步多的那三步

1. 在 **Bean後處理器** before方法之前
   * 檢查Bean是否實現了Aware相關的介面，如果實現了介面則調用這些介面中的方法。
   然後調用這些方法的目的是為了給你傳遞一些數據，讓你更加方便使用。

2. 在 **Bean後處理器** before方法之後
   * 檢查Bean是否實現了InitializingBean介面，如果實現了，則調用介面中的方法。

3. 使用Bean之後，或者說銷毀Bean之前
   * 檢查Bean是否實現了DisposableBean介面，如果實現了，則調用介面中的方法。

添加的這三個點位的特點：都是在檢查你這個Bean是否實現了某些特定的介面，如果實現了這些介面，則Spring容器會調用這個介面中的方法。
