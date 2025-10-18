package com.www.wstore.controller;

import com.www.wstore.common.R;
import com.www.wstore.service.ProductService;
import com.www.wstore.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/{id}")
    R<ProductVo> getProductWithCategory(@PathVariable Long id){
        return productService.getProductWithCategory(id);
    }
    @GetMapping
    R<ArrayList<ProductVo>> getProductAll(){
        return productService.getProductAll();
    }
}
