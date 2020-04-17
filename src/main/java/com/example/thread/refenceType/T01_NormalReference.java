package com.example.thread.refenceType;

/***
 * 只要有引用存在 谁都回收不掉
 */
public class T01_NormalReference {

    public static void main(String[] args) throws Exception{
        M m = new M();
        m=null;
      //  System.gc();
        System.in.read();
    }

}
