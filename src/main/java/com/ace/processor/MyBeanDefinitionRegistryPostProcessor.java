package com.ace.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry:手动注册BeanDefinition");
        // 创建BeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setInitMethodName("init");
        beanDefinition.setBeanClassName("com.ace.service.impl.UserServiceImpl");
        // 创建property
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        // 注入依赖 不需要区分value和ref，估计spring在解析时会将ref赋值给value
        propertyValues.addPropertyValue("userDao",beanDefinitionRegistry.getBeanDefinition("userDao"));
        beanDefinition.setPropertyValues(propertyValues);
        // 注册到BeanDefinitionMap上
        beanDefinitionRegistry.registerBeanDefinition("userService2", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory:手动注册BeanDefinition");
    }
}
