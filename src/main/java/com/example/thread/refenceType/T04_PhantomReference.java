package com.example.thread.refenceType;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理堆外内存 DirectByteBuffer(NIO的API 直接指向JVM外的内存 不需要Copy到JVM中 操作系统直接管理)，JVM回收不了
 * 当某个这种引用被回收的时候 会通知队列(队列加一个值) 然后清理堆外内存(GC线程)
 *
 */
public class T04_PhantomReference {
    public static final List<Object> LIST = new ArrayList<>();
    public static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();
    public static void main(String[] args) {
        PhantomReference<M> phantomReference=new PhantomReference<>(new M(),QUEUE);
        new Thread(() -> {
           while (true){
               LIST.add(new byte[1204*1024*10]);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   Thread.currentThread().interrupt();
               }
               /**虚引用永远拿不到值*/
               System.out.println(phantomReference.get());
           }
        }).start();

        new Thread(() -> {
           while (true){
               Reference<? extends M> poll=QUEUE.poll();
               if (poll!=null){
                   System.out.println("虚引用被JVM回收了-----"+poll);
               }
           }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
