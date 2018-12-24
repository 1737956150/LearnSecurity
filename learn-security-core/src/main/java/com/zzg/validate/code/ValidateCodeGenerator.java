package com.zzg.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @classname ValidateCodeGenerator
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/24 11:56
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}
