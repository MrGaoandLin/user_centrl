package com.ut.login.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description: 创建全局缓存保存用户信息
 * User: gaolei
 * Date: 2018/7/6
 * Time: 下午 04:17
 */
public class MapCache {

    private static Map<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();

    public MapCache(String cookieId, Map<String,Object> userMap) {

    }

    public static void setCacheMap(String key,Object value){

        cacheMap.put(key,value);
    }

    public static Map<String,Object> getCacheMap(){
        return cacheMap;
    }
}
