package com.example.thread.refenceType;

import java.lang.ref.SoftReference;

/***
 * 空间不够就会回收
 * 软引用适合做缓存(空间足够就放在那里 不够用会回收)
 */
public class T02_SoftReference {

    public static void main(String[] args) throws Exception{
        /***
         * m指向SoftReference 对象
         * SoftReference 对象里面还有一个引用 是软引用 指向一个字节数组(10M)
         */
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc(); /**gc不是在主线程 所以sleep 1s**/
        Thread.sleep(1000);
        System.out.println(m.get());
        //在new一个数组(强引用) heap将装不下，这时候系统会垃圾回收一次 如果不够 就把软引用
        byte[] b=new byte[1024*1024*15];
        System.out.println(m.get());
    }

}
