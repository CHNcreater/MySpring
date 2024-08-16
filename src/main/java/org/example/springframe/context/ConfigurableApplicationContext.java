package org.example.springframe.context;

import org.example.springframe.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws BeansException;
}
