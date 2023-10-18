package com.akihi.serendipity.common.utils;

import org.springframework.http.HttpStatus;

import java.io.Serializable;


public class R<T> implements Serializable {

        private static final long serialVersionUID = 1L;

        private int code;

        private String msg;

        private T data;

        public static <T> R<T> ok() {
            return restResult(null, HttpStatus.OK.value(), null);
        }

        public static <T> R<T> ok(T data) {
            return restResult(data, HttpStatus.OK.value(), null);
        }

        public static <T> R<T> ok(T data, String msg) {
            return restResult(data, HttpStatus.OK.value(), msg);
        }

        public static <T> R<T> failed() {
            return restResult(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
        }

        public static <T> R<T> failed(String msg) {
            return restResult(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
        }

        public static <T> R<T> failed(T data) {
            return restResult(data, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
        }

        public static <T> R<T> failed(T data, String msg) {
            return restResult(data, HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
        }

        public static <T> R<T> restResult(T data, int code, String msg) {
            R<T> apiResult = new R<>();
            apiResult.setCode(code);
            apiResult.setData(data);
            apiResult.setMsg(msg);
            return apiResult;
        }

        public int getCode() {
            return code;
        }

        public R<T> setCode(int code) {
            this.code = code;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public R<T> setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public T getData() {
            return data;
        }

        public R<T> setData(T data) {
            this.data = data;
            return this;
        }
    }
