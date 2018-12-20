package com.zzg.properties;

/**
 * @classname BrowserProperties
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/20 14:19
 */
public class BrowserProperties {

    private String loginPage = "/zzg-login.html";

    private LoginType loginType = LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
