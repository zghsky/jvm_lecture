package com.shengsiyuan.jvm.classloader;

public class MySample {

    public MySample() {
        System.out.println("MySample is loader by: " + this.getClass().getClassLoader());

        new MyCat();
    }
}
