package com.www.wstore.mapper;

import com.www.wstore.entity.Man;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManMapper {
  List<Man> findAll();
}
