package com.www.wstore.service;


import com.www.wstore.common.R;
import com.www.wstore.entity.User;

public interface UserService {
    R<String> login(User user);
}
