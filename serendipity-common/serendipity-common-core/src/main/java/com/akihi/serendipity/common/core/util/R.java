package com.akihi.serendipity.common.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private String code;

        private String statusCode;

        private String message;

        private List<Map<String, String>> errors;

        private T data;

        public static <T> R<T> ok() {
            return restResult(null, "request_success", null);
        }

        public static <T> R<T> ok(T data) {
            return restResult(data, "request_success", null);
        }

        public static <T> R<T> ok(T data, String msg) {
            return restResult(data, "request_success", msg);
        }

        public static <T> R<T> failed() {
            return restResult(null, "request_failed", null);
        }

        public static <T> R<T> failed(String msg) {
            return restResult(null, "request_failed", msg);
        }

        public static <T> R<T> failed(T data) {
            return restResult(data, "request_failed", null);
        }

        public static <T> R<T> failed(T data, String msg) {
            return restResult(data, "request_failed", msg);
        }

        public static <T> R<T> restResult(T data, String code, String msg) {
            R<T> apiResult = new R<>();
            apiResult.setCode(code);
            apiResult.setData(data);
            apiResult.setMsg(msg);
            return apiResult;
        }

        public String getCode() {
            return code;
        }

        public R<T> setCode(String code) {
            this.code = code;
            return this;
        }

        public String getMsg() {
            return message;
        }

        public R<T> setMsg(String message) {
            this.message = message;
            return this;
        }

        public T getData() {
            return data;
        }

        public R<T> setData(T data) {
            this.data = data;
            return this;
        }

    public List<Map<String, String>> getErrors() {
        return errors;
    }

    public R<T> setErrors(List<Map<String, String>> errors) {
        this.errors = errors;
        return this;
    }
}
