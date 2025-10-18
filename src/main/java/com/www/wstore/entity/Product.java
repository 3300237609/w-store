package com.www.wstore.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * 商品实体类
 * 对应数据库表products
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    /**
     * 商品唯一ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品SKU编码（唯一）
     */
    @Column(unique = true, nullable = false, length = 50)
    private String sku;

    /**
     * 商品名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 商品分类ID（关联分类表）
     */
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    /**
     * 品牌ID（关联品牌表）
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 商品售价
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * 商品原价
     */
    @Column(name = "original_price", precision = 10, scale = 2)
    private BigDecimal originalPrice;

    /**
     * 商品库存数量
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * 商品销量
     */
    @Column(nullable = false)
    private Integer sales;

    /**
     * 商品主图URL
     */
    @Column(name = "main_image", nullable = false, length = 512)
    private String mainImage;

    /**
     * 商品多图URL，用逗号分隔
     */
    @Column(columnDefinition = "TEXT")
    private String images;

    /**
     * 商品详细描述
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * 商品规格参数（JSON格式）
     */
    @Column(columnDefinition = "TEXT")
    private String specifications;

    /**
     * 是否上架：1-上架，0-下架
     */
    @Column(name = "is_on_sale", nullable = false)
    private Boolean onSale = true;

    /**
     * 是否删除：1-删除，0-正常
     */
    @Column(name = "is_delete", nullable = false)
    private Boolean deleted = false;

    /**
     * 排序权重（值越大越靠前）
     */
    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder = 0;

    /**
     * 创建时间
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}

