package com.zzg.validate.code.sms;

import org.springframework.stereotype.Component;

/**
 * @classname DefaultSmsCodeSender
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/24 16:07
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("此处定义自己向手机发送验证码的逻辑");
        System.out.println("手机号是："+mobile+"验证码是："+code);
    }
}
