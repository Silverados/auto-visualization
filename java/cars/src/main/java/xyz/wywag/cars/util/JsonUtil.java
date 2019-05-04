package xyz.wywag.cars.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonUtil {
    private static Gson gson;
    static {
        if (gson == null){
            gson = new GsonBuilder().setPrettyPrinting().create();
        }
    }


    /**
     * 将常规object对象转成json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }


    /**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T toBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }


    /**
     * 转成list
     * 解决泛型问题
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }



    /**
     * 转成list中有map的
     * T,V分别是key,value的泛型
     * @param gsonString
     * @return
     */
    public static <K,V> List<Map<K,V>> toListMaps(String gsonString, Class<K> k, Class<V> v) {
        List<Map<K,V>> list = new ArrayList<>();
        Map<K, V> map = new HashMap<>();
        JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, map.getClass()));
        }
        return list;
    }


    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> ToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }


}
