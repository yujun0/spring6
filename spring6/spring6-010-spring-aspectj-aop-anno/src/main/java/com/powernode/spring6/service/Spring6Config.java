package com.powernode.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 代替spring.xml文件
@ComponentScan({"com.powernode.spring6.service"})  // 組件掃描
@EnableAspectJAutoProxy(proxyTargetClass = true)// 啟用aspectj的自動代理機制。
public class Spring6Config {}