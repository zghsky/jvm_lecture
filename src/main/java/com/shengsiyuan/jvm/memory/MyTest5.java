package com.shengsiyuan.jvm.memory;

public class MyTest5 {

    public static void main(String[] args) {

        for (; ;) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        }
    }
}
