package com.shengsiyuan.jvm.classloader;


import java.util.Random;

/**
 * 当一个接口在初始化时, 并不要求其父接口都完成了初始化
 * 只有在真正使用到父类接口的时候 (如引用接口中定义的常量时), 才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {

    public static final int a = 6;
}

class MyChild5 implements MyParent5 {

    public static final int b = new Random().nextInt(2);
}
