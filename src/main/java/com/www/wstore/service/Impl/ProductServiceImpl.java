package com.www.wstore.service.Impl;

import com.www.wstore.common.R;
import com.www.wstore.mapper.ProductMapper;
import com.www.wstore.service.ProductService;
import com.www.wstore.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public R<ProductVo> getProductWithCategory(Long id) {
        if (id==null){
            return R.error("err!");
        }
        ProductVo productWithCategory = productMapper.getProductWithCategory(id);
        if (productWithCategory==null){
            return R.error("没找到！");
        }
        return R.success(productWithCategory);
    }

    @Override
    public R<ArrayList<ProductVo>> getProductAll() {
        ArrayList<ProductVo> productAll = productMapper.getProductAll();
        if (productAll==null||productAll.isEmpty()){
            return R.error("异常！");
        }
        return R.success(productAll);
    }
}
