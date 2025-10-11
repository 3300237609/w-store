package com.www.wstore.mapper;

import com.www.wstore.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User longin(User user);
}
