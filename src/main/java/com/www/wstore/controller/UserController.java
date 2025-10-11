package com.www.wstore.controller;

import com.www.wstore.common.R;
import com.www.wstore.entity.User;
import com.www.wstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@GetMapping("/a")
    public R<String> a(){
        return R.success("成功！");
}
    @GetMapping("/b")
    public void b(){

    }
}
