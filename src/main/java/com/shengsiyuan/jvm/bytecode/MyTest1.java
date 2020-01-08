package com.shengsiyuan.jvm.bytecode;

/**
 * 1、使用javap -verbose 命令分析一个字节码文件时, 将会分析该字节码文件的魔数、版本号、常量池、类信息、类的构造方法、
 *    类中的方法信息、类变量与成员变量等信息。
 * 2、魔数: 所有的 .class 字节码文件的前4个字节都是魔数、魔数值为固定值: 0xCAFEBABE
 * 3、魔数之后的4个字节是版本信息, 前两个字节表示minor version (次版本号), 后两个字节表示major version (主版本号)。
 *    这里的版本号为 00 00 00 34, 换算成十进制, 表示次版本号为0, 主版本号为52. 所以, 该文件版本号为1.8.0。可以用
 *    java -version 命令验证。
 * 4、常量池 (constant pool): 紧接着版本号之后的就是常量池入口。一个java类定义的很多信息都是由常量池来维护和描述的,
 *    可以将常量池看作是class文件的资源仓库, 比如说Java类定义的方法与变量信息, 都是存储在常量池中。常量池主要存储
 *    两类常量: 字面量与符号引用。字面量如文本字符串, Java中声明为final的常量值等, 而符号引用如类和接口的全局限定名,
 *    字段的名称和描述符, 方法的名称和描述符等。
 * 5、
 */
public class MyTest1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
