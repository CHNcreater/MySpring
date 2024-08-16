package org.example.springframe.beans.factory;

import org.example.springframe.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    public <T extends Object> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    public String getBeanDefinitionNames() throws BeansException;
}
