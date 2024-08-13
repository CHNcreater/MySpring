package org.example.springframe.beans.factory.support;

import org.example.springframe.beans.BeansException;
import org.example.springframe.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException;

}
