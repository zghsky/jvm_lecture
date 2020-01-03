package com.shengsiyuan.jvm.classloader;

import java.util.Random;

public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSomething();
    }
}

class Parent3 {
    static int a = new Random().nextInt(5);

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child static block");
    }
}
