package com.sf.tinker.utils

import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.sf.tinker.entity.ResultEntity
import com.sf.tinker.exception.HttpResponseCodeError
import okhttp3.*
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap


/**
 * Created by 01243141 on 2017/12/14.
 */

object HttpUtil {
    private val client = OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build()
    fun post(url: String, params: Map<String, Any>): String? {
        val request = Request.Builder()
                .url(url)
                .post(makeParams(params))
                .build()
        val call = client.newCall(request)
        var response = call.execute()
        if (response.code() != 200) {
            throw HttpResponseCodeError(response.code(), response.body().string())
        }
        if (response.isSuccessful) {
            return response.body().string()
        }
        return null
    }

    private fun makeParams(params: Map<String, Any>): RequestBody? {
        val requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), JsonUtil.toJson(params))
        return requestBody
    }

    fun get(url: String): String? {
        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        val call = client.newCall(request)
        var response = call.execute()
        if (response.code() != 200) {
            throw HttpResponseCodeError(response.code(), response.body().string())
        }
        if (response.isSuccessful) {
            return parseContent(response.body().string())
        }
        return null
    }

    fun <T> post(url: String, params: Map<String, Any>, clazz: Class<T>): T? {
        val request = Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .post(makeParams(params))
                .build()
        val call = client.newCall(request)
        var response = call.execute()
        if (response.code() != 200) {
            throw HttpResponseCodeError(response.code(), response.body().string())
        }
        if (response.isSuccessful) {
            return JsonUtil.fromJson(parseContent(response.body().string()), clazz)
        }
        return null
    }

    fun <T> postList(url: String, params: Map<String, Any>): List<T>? {
        val request = Request.Builder()
                .url(url)
                .post(makeParams(params))
                .build()
        //MediaType  设置Content-Type 标头中包含的媒体类型值
        val call = client.newCall(request)
        var response = call.execute()
        if (response.code() != 200) {
            throw HttpResponseCodeError(response.code(), response.body().string())
        }
        if (response.isSuccessful) {
            return JsonUtil.fromJsonList(parseContent(response.body().string()), object : TypeToken<ArrayList<T>>() {}.type)
        }
        return null
    }

    fun <T> getList(url: String): List<T>? {
        val request = Request.Builder()
                .url(url)
                .get().addHeader("Content-Type", "application/json")
                .build()
        val call = client.newCall(request)
        var response = call.execute()
        if (response.code() != 200) {
            throw HttpResponseCodeError(response.code(), response.body().string())
        }
        if (response.isSuccessful) {
            return JsonUtil.fromJsonList(parseContent(response.body().string()), object : TypeToken<ArrayList<T>>() {}.type)
        }
        return null
    }

    fun <T> get(url: String, clazz: Class<T>): T? {
        val request = Request.Builder()
                .url(url)
                .get().header("Content-Type", "application/json")
                .build()
        val call = client.newCall(request)
        var response = call.execute()
        if (response.code() != 200) {
            throw HttpResponseCodeError(response.code(), response.body().string())
        }
        if (response.isSuccessful) {
            return JsonUtil.fromJson(parseContent(response.body().string()), clazz)
        }
        return null
    }


    private fun parseContent(result: String?): String {
        var resultEntity: ResultEntity? = JsonUtil.fromJson(result, ResultEntity::class.java) ?: throw JsonParseException("obj=null")
        if (!resultEntity?.success!!) {
            throw throw HttpResponseCodeError(resultEntity.errorCode, resultEntity.errorMessage)
        }
        println("resultEntity.obj = ${resultEntity.obj}")
        return resultEntity?.obj!!
    }


    fun getParams(): HashMap<String, Any> {
        val params = HashMap<String, Any>()
        return params
    }


    fun getPageParam(): HashMap<String, Any> {
        val params = getParams()
        params.put("pageSize", 20)
        return params
    }

}
