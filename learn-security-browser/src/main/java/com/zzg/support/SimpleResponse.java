package com.zzg.support;

/**
 * @classname SimpleResponse
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/20 9:05
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
