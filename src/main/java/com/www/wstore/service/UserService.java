package com.www.wstore.service;


import com.www.wstore.common.R;
import com.www.wstore.entity.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    R<User> login(User user, HttpServletResponse response);
    R<String> logout(HttpServletResponse response);
}
