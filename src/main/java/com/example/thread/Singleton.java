package com.example.thread;

public class Singleton {
    private static  volatile Singleton singleton=null;
    static  int x ,y ,a ,b;
    private Singleton(){

    }
    public  static Singleton getInstance(){
        if (singleton==null){
            System.out.println("我的其他业务");//如果多个线程同时执行到了这里 下面不加锁,依然可以产生多个实例 DCL
            synchronized (Singleton.class){//Double Check Lock
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws Exception{
        int i=0;
        for (;;){
            i++;
            x=0;y=0;
            a=0; b=0;
            Thread one = new Thread(() -> {
                 a=1;x=b;
            });
            Thread two = new Thread(() -> {
                b=1;y=a;
            });
            one.start();two.start();
            one.join(); two.join();
            String result="第"+i+"次执行 ("+x+" "+y+")";
            if (x==0&&y==0){
                System.out.println(result);
                break;
            }else{

            }
        }
    }
}
