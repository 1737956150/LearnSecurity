package com.zzg.properties;

/**
 * @classname ImageCodeProperties
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/24 11:14
 */
public class ImageCodeProperties extends SmsCodeProperties{

    private int width = 67;
    private int height = 23;

    // 验证码拦截接口可配置， 多个url逗号隔开
    private String url;

    public ImageCodeProperties(){
        setLength(4);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
