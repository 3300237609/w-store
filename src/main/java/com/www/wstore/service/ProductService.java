package com.www.wstore.service;

import com.www.wstore.common.R;
import com.www.wstore.vo.ProductVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface ProductService {
    R<ProductVo> getProductWithCategory(Long id);
    R<ArrayList<ProductVo>> getProductAll();
}
