package org.example.springframe.beans.factory;

import org.example.BeansException;

public interface BeanFactory {
    public Object getBean(String beanName) throws BeansException;
}
