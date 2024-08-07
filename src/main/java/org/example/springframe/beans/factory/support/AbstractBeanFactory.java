package org.example.springframe.beans.factory.support;

import org.example.BeansException;
import org.example.springframe.beans.factory.BeanFactory;
import org.example.springframe.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        Object bean = this.createBean(beanName, beanDefinition);
        return bean;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
