package com.www.wstore;

import com.www.wstore.service.ProductService;
import com.www.wstore.service.UserService;
import com.www.wstore.vo.ProductVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WStoreApplicationTests {
    @Autowired
    private ProductService productService;


    @Test
    void contextLoads() {
        ProductVo productWithCategory = productService.getProductWithCategory(1L);
        System.err.println(productWithCategory);
    }

}