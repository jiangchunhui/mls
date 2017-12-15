package com.sf.tinker.exception;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class HttpResponseCodeError extends RuntimeException {
    public HttpResponseCodeError(int code, String result) {
        super("code:" + code + ";result=" + result);
    }
}
