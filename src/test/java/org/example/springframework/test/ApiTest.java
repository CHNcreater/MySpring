package org.example.springframework.test;

import org.example.springframe.beans.BeansException;
import org.example.springframe.beans.PropertyValue;
import org.example.springframe.beans.PropertyValues;
import org.example.springframe.beans.factory.config.BeanDefinition;
import org.example.springframe.beans.factory.config.BeanReference;
import org.example.springframe.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.example.springframe.beans.factory.support.DefaultListableBeanFactory;
import org.example.springframe.beans.factory.support.SimpleInstantiationStrategy;
import org.example.springframework.test.bean.UserDao;
import org.example.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

    @Test
    public void test_BeanFactory_with_parameters() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "Joey");
        userService.queryUserInfo();
        System.out.println(userService);
    }

    @Test
    public void test_BeanFactory_with_parameters_cglib() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setInstantiationStrategy(new CglibSubclassingInstantiationStrategy());
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "Joey");
        userService.queryUserInfo();
        System.out.println(userService);
    }

    @Test
    public void test_BeanFactory_with_propertyValues() throws BeansException {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);
        defaultListableBeanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService", "Joey");
        userService.queryUserInfoByUid();
    }
}
