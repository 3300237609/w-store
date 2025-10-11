package com.www.wstore.service.Impl;

import com.www.wstore.entity.Man;
import com.www.wstore.mapper.ManMapper;
import com.www.wstore.service.manService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class manServiceImpl implements manService {

    // 自动注入Mapper
    @Autowired
    private ManMapper manMapper;

    @Override
    public List<Man> findAll() {
        return manMapper.findAll();
    }
}
