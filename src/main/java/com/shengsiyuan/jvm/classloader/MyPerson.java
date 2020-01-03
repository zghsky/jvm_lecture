package com.shengsiyuan.jvm.classloader;

public class MyPerson {

    static {
        System.out.println("MyPerson static block start......");
    }

    private MyPerson myPerson;

    public void setMyPerson(Object object) {
        this.myPerson = (MyPerson) object;
    }

    public MyPerson getMyPerson() {
        return this.myPerson;
    }

    public String toString() {
        return "loader by MyClassLoader: " + this.getClass().getClassLoader();
    }
}
