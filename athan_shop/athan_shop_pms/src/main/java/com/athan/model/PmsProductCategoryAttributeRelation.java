package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 * @TableName pms_product_category_attribute_relation
 */
@TableName(value ="pms_product_category_attribute_relation")
@Data
public class PmsProductCategoryAttributeRelation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long productCategoryId;

    /**
     * 
     */
    private Long productAttributeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}