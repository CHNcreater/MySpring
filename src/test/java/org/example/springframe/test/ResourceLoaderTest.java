package org.example.springframe.test;

import cn.hutool.core.io.IoUtil;
import org.example.springframe.beans.BeansException;
import org.example.springframe.beans.factory.support.DefaultListableBeanFactory;
import org.example.springframe.beans.factory.xml.XmlBeanDefinitionReader;
import org.example.springframe.core.io.DefaultResourceLoader;
import org.example.springframe.core.io.Resource;
import org.example.springframe.test.bean.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {

    private static DefaultResourceLoader resourceLoader;

    @BeforeAll
    public static void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() throws IOException, BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
