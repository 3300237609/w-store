package com.www.wstore;

import com.www.wstore.entity.Man;
import com.www.wstore.entity.User;
import com.www.wstore.service.Impl.manServiceImpl;
import com.www.wstore.service.UserService;
import com.www.wstore.service.manService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WStoreApplicationTests {
    @Autowired
    private manService manService;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<Man> all = manService.findAll();
        System.err.println(all.get(0).toString());
    }

}