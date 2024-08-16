package org.example.springframe.beans.factory.config;

import org.example.springframe.beans.BeansException;
import org.example.springframe.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
