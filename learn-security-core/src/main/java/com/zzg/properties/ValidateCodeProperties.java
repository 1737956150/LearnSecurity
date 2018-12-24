package com.zzg.properties;

/**
 * @classname ValidateCodeProperties
 * @desc TODO 封装验证码（图形验证码/短信验证码）
 * @author: zzg
 * @date: 2018/12/24 11:16
 */
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }
}
