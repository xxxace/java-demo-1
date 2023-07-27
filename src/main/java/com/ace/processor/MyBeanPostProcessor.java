package com.ace.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.Date;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----postProcessBeforeInitialization" + "[" + beanName + "]" + "-----");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----postProcessAfterInitialization" + "[" + beanName + "]" + "------");
        System.out.println("bean = " + bean + ", beanName = " + beanName);
        Object proxyBean = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("方法：" + method.getName() + "-开始时间：" + new Date());
                    Object resulte = method.invoke(bean, args);
                    System.out.println("方法：" + method.getName() + "-结束时间：" + new Date());
                    return resulte;
                }
        );

        return proxyBean;
    }
}
