package com.example.nio.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/****
 * AIO：当客户端需要连接的时候 交给操作系统去链接
 * 操作系统一旦连接上了客户端 才会给大管家Selector有人要连上来了
 * 大管家只负责连接的功能 而不需要轮循环，连好的通过交给工人worker处理通道里面的信息
 */
public class Server {
    public static void main(String[] args) throws Exception {
        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8888));
        /***
         * CompletionHandler和accept不阻塞:类似观察者的设计模式
         * 处理的代码写好交给你，什么时候完成了 自己去调用，又叫回调函数
         */
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                serverChannel.accept(null, this);
                try {
                    System.out.println(client.getRemoteAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    /**此处的CompletionHandler和accept中的CompletionHandler一样 用的观察者设计模式**/
                    client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("HelloClient".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        while (true) {
            Thread.sleep(1000);
        }

    }
}
