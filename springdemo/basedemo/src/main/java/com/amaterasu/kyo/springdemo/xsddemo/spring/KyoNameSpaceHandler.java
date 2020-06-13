package com.amaterasu.kyo.springdemo.xsddemo.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-06-10 20:29
 **/
public class KyoNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        super.registerBeanDefinitionParser("application", new KyoBeanDefinitionParser(ApplicationConfig.class));
        super.registerBeanDefinitionParser("service", new KyoBeanDefinitionParser(ServiceBean.class));
    }
}
