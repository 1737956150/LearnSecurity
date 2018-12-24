package com.zzg.properties;

/**
 * @classname ImageCodeProperties
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/24 11:14
 */
public class SmsCodeProperties {

    private int length = 4;
    private int expireIn = 60;

    // 验证码拦截接口可配置， 多个url逗号隔开
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
