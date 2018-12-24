package com.zzg.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @classname SecurityProperties
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/20 14:19
 */
@ConfigurationProperties("zzg.security")
public class SecurityProperties {

   private BrowserProperties browser =  new BrowserProperties();

   private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
