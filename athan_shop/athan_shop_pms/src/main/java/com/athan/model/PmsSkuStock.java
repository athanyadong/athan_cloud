package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * sku的库存
 * @TableName pms_sku_stock
 */
@TableName(value ="pms_sku_stock")
@Data
public class PmsSkuStock implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *  产品编号
     */
    private Long productId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     *  价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 预警库存
     */
    private Integer lowStock;

    /**
     * 展示图片
     */
    private String pic;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 单品促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    private Integer lockStock;

    /**
     * 商品销售属性，json格式
     */
    private String spData;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}