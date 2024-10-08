package org.example.springframe.context.support;

import org.example.springframe.beans.BeansException;
import org.example.springframe.beans.factory.ConfigurableListableBeanFactory;
import org.example.springframe.beans.factory.config.BeanFactoryPostProcessor;
import org.example.springframe.beans.factory.config.BeanPostProcessor;
import org.example.springframe.context.ConfigurableApplicationContext;
import org.example.springframe.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        //1. Create Bean Factory and load BeanDefinition
        refreshBeanFactory();
        //2. Get BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //3. Execute BeanFactoryPostProcessor before Bean Instantiation
        invokeBeanFactoryPostProcessors(beanFactory);
        //4. Register BeanPostProcessor before bean instantiation
        registerBeanPostProcessors(beanFactory);
        //5. pre instantiate bean object
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }
}
