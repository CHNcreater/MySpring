package org.example.springframe.beans.factory;

import org.example.springframe.beans.BeansException;

public interface BeanFactory {
    public Object getBean(String beanName) throws BeansException;

    public Object getBean(String beanName, Object... args) throws BeansException;
}
