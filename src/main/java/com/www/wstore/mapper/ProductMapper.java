package com.www.wstore.mapper;

import com.www.wstore.common.R;
import com.www.wstore.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ProductMapper {
    ProductVo getProductWithCategory(Long id);
    ArrayList<ProductVo> getProductAll();
}
