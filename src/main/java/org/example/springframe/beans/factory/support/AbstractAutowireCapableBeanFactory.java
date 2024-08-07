package org.example.springframe.beans.factory.support;

import org.example.BeansException;
import org.example.springframe.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            throw new BeansException(e);
        } catch (IllegalAccessException e) {
            throw new BeansException(e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
