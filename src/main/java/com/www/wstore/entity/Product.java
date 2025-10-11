package com.www.wstore.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;

/**
 * 商品实体类
 * 对应数据库表products
 */
@Entity
@Table(name = "products")
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

    // 构造方法
    public Product() {
    }

    // Getter和Setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", onSale=" + onSale +
                '}';
    }
}
