package com.example.zookeeper;

import org.apache.zookeeper.ZooKeeper;

public class ZKClient {

    public static void main(String[] args) throws  Exception{
        String conn="122.51.193.97:2181";
        ZooKeeper zooKeeper = new ZooKeeper(conn,500,null);
    }

}
