package com.example.nio.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        /**ServerSocketChannel 这个通道是双向的 可以读可以写**/
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
        //设置成非阻塞
        ssc.configureBlocking(false);

        System.out.println("server started, listening on :" + ssc.getLocalAddress());
        Selector selector = Selector.open();
        //注册对哪些事件感兴趣:OP_ACCEPT
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while(it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();
                handle(key);
            }
        }

    }

    private static void handle(SelectionKey key) {
        if(key.isAcceptable()) {//说明有一个客户端要连上来
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //new Client
                //
                //String hostIP = ((InetSocketAddress)sc.getRemoteAddress()).getHostString();

			/*
			log.info("client " + hostIP + " trying  to connect");
			for(int i=0; i<clients.size(); i++) {
				String clientHostIP = clients.get(i).clientAddress.getHostString();
				if(hostIP.equals(clientHostIP)) {
					log.info("this client has already connected! is he alvie " + clients.get(i).live);
					sc.close();
					return;
				}
			}*/

                sc.register(key.selector(), SelectionKey.OP_READ );
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        } else if (key.isReadable()) { //flip
            SocketChannel sc = null;
            try {
                sc = (SocketChannel)key.channel();
                /**buffer就是内存中的一个字节数组 它会把字节数组填满或者填到一定位置，直接从字节数组读和写**/
                ByteBuffer buffer = ByteBuffer.allocate(512);
                buffer.clear();
                int len = sc.read(buffer);

                if(len != -1) {
                    System.out.println(new String(buffer.array(), 0, len));
                }

                ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
                sc.write(bufferToWrite);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(sc != null) {
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
