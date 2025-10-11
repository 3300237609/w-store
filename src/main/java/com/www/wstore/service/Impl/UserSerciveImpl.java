package com.www.wstore.service.Impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.www.wstore.Utils.JwtUtil;
import com.www.wstore.common.R;
import com.www.wstore.entity.User;
import com.www.wstore.mapper.UserMapper;
import com.www.wstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerciveImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public R<String> login(User user) {
        if (StrUtil.isBlank(user.getName()) || StrUtil.isBlank(user.getPassword())) {
            return R.error("数据异常！");
        }
        User longin = userMapper.longin(user);
        if (ObjectUtil.isEmpty(longin)) {
            return R.error("账号或密码错误！");
        }
        String token = jwtUtil.generateToken(longin.getId().toString(), longin.getName());
        return R.success(token);
//        return R.success(longin);
    }
}
