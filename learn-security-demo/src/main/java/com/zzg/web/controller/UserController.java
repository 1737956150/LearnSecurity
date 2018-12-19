package com.zzg.web.controller;

import com.zzg.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname UserController
 * @desc TODO RestFul 测试UserController
 * @author: zzg
 * @date: 2018/12/19 15:35
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public List<User> queryUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }
}
