package com.neuedu.util;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private static final Map<String,Object> map = new HashMap<>();

    public static void put(String s, Object object){
        map.put(s, object);
    }

    public static <T> T  get(String key){
        return (T) map.get(key);
    }

//    public static void remove(String key){
//        map.remove(key);
//    }



}
