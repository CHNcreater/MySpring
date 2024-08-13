package org.example.springframe.utils;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        return new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
    }
}
