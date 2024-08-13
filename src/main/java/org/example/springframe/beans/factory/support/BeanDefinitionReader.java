package org.example.springframe.beans.factory.support;

import org.example.springframe.beans.BeansException;
import org.example.springframe.core.io.Resource;
import org.example.springframe.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
