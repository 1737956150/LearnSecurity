package com.zzg.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @classname ValidateCodeProcessor
 * @desc TODO 校验码处理器，封装不同校验码的处理逻辑
 * @author: zzg
 * @date: 2018/12/25 10:00
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
