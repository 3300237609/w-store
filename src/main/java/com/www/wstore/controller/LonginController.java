package com.www.wstore.controller;

import cn.hutool.json.JSONUtil;
import com.www.wstore.common.R;
import com.www.wstore.entity.User;
import com.www.wstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LonginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public R<User> login(@RequestBody User user, HttpServletResponse response){
        return userService.login(user,response);
    }
    @PostMapping("/logout")
    public R<String> logout(HttpServletResponse response){
        return userService.logout(response);
    }

}
