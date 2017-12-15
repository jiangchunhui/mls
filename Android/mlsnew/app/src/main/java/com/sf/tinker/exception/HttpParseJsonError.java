package com.sf.tinker.exception;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class HttpParseJsonError extends RuntimeException {
    public HttpParseJsonError(String error) {
        super(error);
    }
}
