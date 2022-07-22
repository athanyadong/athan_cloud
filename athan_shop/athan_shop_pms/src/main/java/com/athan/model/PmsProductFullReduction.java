package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 产品满减表(只针对同商品)
 * @TableName pms_product_full_reduction
 */
@TableName(value ="pms_product_full_reduction")
@Data
public class PmsProductFullReduction implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long productId;

    /**
     * 
     */
    private BigDecimal fullPrice;

    /**
     * 
     */
    private BigDecimal reducePrice;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}