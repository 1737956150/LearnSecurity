package com.zzg.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @classname ValidateCodeException
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/21 9:27
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
