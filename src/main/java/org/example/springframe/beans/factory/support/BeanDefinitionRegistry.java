package org.example.springframe.beans.factory.support;

import org.example.springframe.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
