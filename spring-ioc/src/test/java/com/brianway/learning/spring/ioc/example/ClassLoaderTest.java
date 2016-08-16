package com.brianway.learning.spring.ioc.example;

import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Created by Brian on 2016/5/12.
 * 类加载器测试
 * 测试当前线程的类加载器以及父加载器
 */
public class ClassLoaderTest {
    @Test
    public void testClassLoader() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader: " + loader);
        System.out.println("parent loader: " + loader.getParent());
        System.out.println("grandparent loader: " + loader.getParent().getParent());
        assertNull(loader.getParent().getParent());
    }
}
