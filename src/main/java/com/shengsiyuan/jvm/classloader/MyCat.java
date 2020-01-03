package com.shengsiyuan.jvm.classloader;

public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loader by: " + this.getClass().getClassLoader());
    }
}
