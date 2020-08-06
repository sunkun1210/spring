package com.example.handler;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Factory {

    private static Map<String,AbstractHandler> strategyMap = new ConcurrentHashMap<>();

    public static void register(String name,AbstractHandler handler){
        strategyMap.put(name,handler);
    }

    public static AbstractHandler getInvokeStrategy(String name){
        return strategyMap.get(name);
    }

}
