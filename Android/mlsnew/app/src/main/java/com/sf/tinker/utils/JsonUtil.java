package com.sf.tinker.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sf.tinker.exception.HttpParseJsonError;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class JsonUtil {
    private static Gson gson = new GsonBuilder().create();

    @Nullable
    public static <T> T fromJson(@Nullable String result, Class<T> clazz) {
        T t = gson.fromJson(result, clazz);
        if (t == null) {
            throw new HttpParseJsonError("json:" + result);
        }
        return t;
    }

    @Nullable
    public static <T> List<T> fromJsonList(@Nullable String result, Type type) {
        List<T> t = gson.fromJson(result, type);
        if (t == null) {
            throw new HttpParseJsonError("json:" + result);
        }
        return t;
    }

    @Nullable
    public static String toJson(@NotNull Map<String, Object> params) {
        return gson.toJson(params);
    }
}
