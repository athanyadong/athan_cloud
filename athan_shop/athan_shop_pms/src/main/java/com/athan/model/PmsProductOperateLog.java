package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName pms_product_operate_log
 */
@TableName(value ="pms_product_operate_log")
@Data
public class PmsProductOperateLog implements Serializable {
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
    private BigDecimal priceOld;

    /**
     * 
     */
    private BigDecimal priceNew;

    /**
     * 
     */
    private BigDecimal salePriceOld;

    /**
     * 
     */
    private BigDecimal salePriceNew;

    /**
     * 赠送的积分
     */
    private Integer giftPointOld;

    /**
     * 
     */
    private Integer giftPointNew;

    /**
     * 
     */
    private Integer usePointLimitOld;

    /**
     * 
     */
    private Integer usePointLimitNew;

    /**
     * 操作人
     */
    private String operateMan;

    /**
     * 
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}