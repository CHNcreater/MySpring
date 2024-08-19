package org.example.springframe.beans.factory.support;

import org.example.springframe.beans.BeansException;
import org.example.springframe.beans.factory.ConfigurableListableBeanFactory;
import org.example.springframe.beans.factory.config.BeanDefinition;
import org.example.springframe.beans.factory.config.BeanPostProcessor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

    }

    @Override
    public void preInstantiateSingletons() {

    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }


    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return Collections.emptyMap();
    }

    @Override
    public String getBeanDefinitionNames() throws BeansException {
        return "";
    }
}
