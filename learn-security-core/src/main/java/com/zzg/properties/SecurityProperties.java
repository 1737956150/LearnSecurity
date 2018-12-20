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

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
