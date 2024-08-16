package org.example.springframe.beans.factory;

import org.example.springframe.beans.factory.config.*;

import java.util.Map;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

    public BeanDefinition getBeanDefinition(String beanName);

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
