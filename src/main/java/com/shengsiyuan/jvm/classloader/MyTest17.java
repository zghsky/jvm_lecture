package com.shengsiyuan.jvm.classloader;

/**
 * 关于命名空间的重要说明
 * <p>
 * 1、子加载器所加载的类能够访问到父加载器所加载的类
 * 2、父加载器所加载的类无法访问代子加载器所加载的类
 */
public class MyTest17 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoaderTest16 loader1 = new ClassLoaderTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("clazz: " + clazz.hashCode());

        // 如果注释改行, 那么并不会实列化MySample对象, 即MySample构造方法不会被调用
        // 因此不会实列化MyCat对象, 即没用对MyCat进行主动使用, 这里就不会加载MyCat Class
        Object object = clazz.newInstance();
    }
}
