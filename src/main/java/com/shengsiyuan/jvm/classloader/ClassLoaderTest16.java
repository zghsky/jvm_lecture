package com.shengsiyuan.jvm.classloader;

import java.io.*;

public class ClassLoaderTest16 extends java.lang.ClassLoader {
    private String classLoaderName;
    private final String fileExtension = ".class";
    private String path;

    public ClassLoaderTest16(String classLoaderName) {
        super();        // 将系统类加载器当作该加载器得父加载器
        this.classLoaderName = classLoaderName;
    }

    public ClassLoaderTest16(String classLoaderName, ClassLoader parent) {
        super(parent);  // 显式指定该加载器得父类加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ClassLoaderTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + name);
        System.out.println("class loader name: " + this.classLoaderName);

        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String name) {
        InputStream in = null;
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;

        name = name.replace('.', '/');

        try {
            in = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int len = 0;
            while ((len = in.read()) != -1) {
                baos.write(len);
            }

            bytes = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassLoaderTest16 loader1 = new ClassLoaderTest16("loader1");
//        test(loader1);
        loader1.setPath("E:\\code\\Java\\");
        Class<?> clazz = loader1.loadClass("Hi");
        System.out.println("class: " + clazz.hashCode());
        Object o = clazz.newInstance();
        System.out.println(o);
        System.out.println(o.getClass().getClassLoader());
        System.out.println("loader1: " + loader1.getClass().getClassLoader());

        System.out.println();

        loader1 = null;
        clazz = null;
        o = null;
        System.gc();

        loader1 = new ClassLoaderTest16("loader1");
        loader1.setPath("E:\\code\\Java\\");
        clazz = loader1.loadClass("Hi");
        System.out.println("class: " + clazz.hashCode());
        o = clazz.newInstance();
        System.out.println(o);
        System.out.println(o.getClass().getClassLoader());
    }

    public static void test(java.lang.ClassLoader classLoader) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        Object o = clazz.newInstance();

        System.out.println(o);
        System.out.println(o.getClass().getClassLoader());
    }
}
