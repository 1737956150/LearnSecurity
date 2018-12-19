package com.zzg.dto;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @classname User
 * @desc TODO
 * @author: zzg
 * @date: 2018/12/19 15:38
 */
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
