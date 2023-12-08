package com.dmkj.ljadmin.common.utils;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 封装httpClient响应结果
 */
public class HttpClientResult implements Serializable {

    private static final long serialVersionUID = 2168152194164783950L;

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    /**
     * 响应数据
     */
    private JSONObject json;

    public HttpClientResult() {
    }

    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(String content) {
        this.content = content;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
        try {
            this.json = JSON.parseObject(content);
        } catch (Exception e) {
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "HttpClientResult [code=" + code + ", content=" + content + "]";
    }

}
