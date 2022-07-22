package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品会员价格表
 * @TableName pms_member_price
 */
@TableName(value ="pms_member_price")
@Data
public class PmsMemberPrice implements Serializable {
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
    private Long memberLevelId;

    /**
     * 会员价格
     */
    private BigDecimal memberPrice;

    /**
     * 
     */
    private String memberLevelName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}