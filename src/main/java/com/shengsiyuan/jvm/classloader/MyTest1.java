package com.shengsiyuan.jvm.classloader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕
 * -XX:+TraceClassLoading, 用于追踪类的加载信息并打印出来
 * <p>
 * 助记符
 * getstatic
 * putstatic
 * invokestatic
 * <p>
 * -XX:+<option>, 表示开启option选项
 * -XX:-<option>, 表示关闭option选项
 * -XX:<option>=<value>, 表示将option选项的值设置为value
 */
public class MyTest1 {
    public static void main(String[] args) {
        // 调用MyChild1类静态属性会导致对类MyChild1主动使用, 从而会导致MyChild1类初始化
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "Hello World";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
