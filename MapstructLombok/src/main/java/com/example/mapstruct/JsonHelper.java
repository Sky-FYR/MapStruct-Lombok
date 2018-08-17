package com.example.mapstruct;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.security.InvalidParameterException;

/**
 * Created by Administrator on 2016/9/20.
 */
public class JsonHelper {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String toJsonStr(Object o) {

        return gson.toJson(o);
    }

    public static <T> T fromJsonStr(String json, Class<T> mapClazz) {
        if (json == null || json.equals("")) {
            throw new InvalidParameterException("The json string is invalid.");
        }

        T obj = null;

        try {
            obj = gson.fromJson(json, mapClazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public static <T> T fromJsonStr(String json, Type type){
        if (json == null || json.equals("")) {
            throw new InvalidParameterException("The json string is invalid.");
        }

        T obj = null;

        try {
            obj = gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return obj;
    }

    //重新转换类型
    public static <T> T convertObject(Object object, Class<T> mapClazz){
        return fromJsonStr(toJsonStr(object), mapClazz);
    }

    public static <T> T convertObject(Object object, Type type){
        return fromJsonStr(toJsonStr(object), type);
    }
}
