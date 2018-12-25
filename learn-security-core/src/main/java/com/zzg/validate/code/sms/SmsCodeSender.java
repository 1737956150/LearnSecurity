package com.zzg.validate.code.sms;

/**
 * @classname SmsCodeSender
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/24 16:06
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
