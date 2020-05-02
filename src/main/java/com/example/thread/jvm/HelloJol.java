package com.example.thread.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class HelloJol {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
        TimeUnit.SECONDS.sleep(5);
        Object o2 = new Object();
        String s2 = ClassLayout.parseInstance(o2).toPrintable();
        System.out.println(s2);
    }
}
