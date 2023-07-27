package com.ace.handlers;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class HaohaoNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        this.registerBeanDefinitionParser("annotation-driven", new HaohaoBeanDefinitionParser());
    }
}
