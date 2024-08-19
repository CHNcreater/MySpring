package org.example.springframe.context.support;

import org.example.springframe.beans.BeansException;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext(){}

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocation() {
        return configLocations;
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return new HashMap<String, T>();
    }

    @Override
    public String getBeanDefinitionNames() throws BeansException {
        return "";
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return null;
    }
}
