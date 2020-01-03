package com.shengsiyuan.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式 (获取 - 使用 - 还原)
 * <p>
 * ClassLoader classloader = Thread.currentThread().getContextCLassLoader();
 * <p>
 * try {
 * Thread.currentThread().setContextClassLoader(targetTcc1);
 * myMethod();
 * } finally {
 * Thread.currentThread().setContextClassLoader(classloader);
 * }
 * <p>
 * myMethod里面则调用了Thread.currentThread().setContextClassLoader(); 获取当前线程上下文类加载器做某些事情。
 * <p>
 * 如果一个类由类加载器A加载, 那么这个类的依赖类也是由相同的类加载器加载的 (如果该依赖类之前没有被加载过的话)
 * <p>
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制。
 * <p>
 * 当高层提供了统一的接口让底层去实现, 同时又要在高层 (或实列化) 底层的类时, 就必须要通过线程上下文类加载器来
 * 帮助高层的ClassLoader找到并加载该类。
 */
public class MyTest26 {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver: " + driver.getClass() +
                    ", loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程的上下文加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());
    }
}
