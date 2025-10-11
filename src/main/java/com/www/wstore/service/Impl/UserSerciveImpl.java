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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Service
public class UserSerciveImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public R<User> login(User user, HttpServletResponse response) {
        if (StrUtil.isBlank(user.getName()) || StrUtil.isBlank(user.getPassword())) {
            return R.error("数据异常！");
        }
        User longin = userMapper.longin(user);
        if (ObjectUtil.isEmpty(longin)) {
            return R.error("账号或密码错误！");
        }
        String token = jwtUtil.generateToken(longin.getId().toString(), longin.getName());
        Cookie cookie = new Cookie("authToken", token);
        // 设置为HttpOnly，防止XSS攻击
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
        return R.success(longin);
    }

    @Override
    public R<String> logout(HttpServletResponse response) {

        // 1. 构建清除Token的Cookie（关键：参数与设置时一致）
        Cookie tokenCookie = new Cookie("authToken", ""); // 名称为"token"，值设为空
        // 跨域场景：设置Domain为后端域名（如后端部署在192.168.240.24）
//        tokenCookie.setDomain("192.168.240.24");
        tokenCookie.setDomain("localhost"); // 改为前端实际访问的域名

        tokenCookie.setMaxAge(0); // 立即过期（核心参数）
        tokenCookie.setPath("/"); // 与设置时一致，通常为"/"（全站有效）
        // 若设置Cookie时加了HttpOnly，此处必须保留（防止前端篡改，清除时也需匹配）
        tokenCookie.setHttpOnly(true);
        // 若为HTTPS环境，需添加Secure（仅HTTPS传输）
        // tokenCookie.setSecure(true);

        // 2. 将清除Cookie的指令通过响应头返回给浏览器
        response.addCookie(tokenCookie);

        // 3. （关键补充）后端同步使Token失效（避免Token被复用）
        // 例如：将Token加入黑名单（Redis存储，有效期与Token原过期时间一致）
        // String token = 从请求中获取旧Token（若需要）;
        // redisTemplate.opsForValue().set("blacklist:" + token, "invalid", 1, TimeUnit.HOURS);

        return R.success("退出成功！");
    }
}
