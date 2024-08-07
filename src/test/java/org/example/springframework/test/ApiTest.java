package org.example.springframework.test;

import org.example.BeansException;
import org.example.springframe.beans.factory.config.BeanDefinition;
import org.example.springframe.beans.factory.support.DefaultListableBeanFactory;
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
}
