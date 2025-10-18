package com.www.wstore.vo;

import com.www.wstore.entity.Product;
import lombok.*;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class ProductVo extends Product {
    private String categoryName;
}
