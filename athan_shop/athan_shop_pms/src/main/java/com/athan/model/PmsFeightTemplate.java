package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 运费模版
 * @TableName pms_feight_template
 */
@TableName(value ="pms_feight_template")
@Data
public class PmsFeightTemplate implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    private Integer chargeType;

    /**
     * 首重kg
     */
    private BigDecimal firstWeight;

    /**
     * 首费（元）
     */
    private BigDecimal firstFee;

    /**
     * 
     */
    private BigDecimal continueWeight;

    /**
     * 
     */
    private BigDecimal continmeFee;

    /**
     * 目的地（省、市）
     */
    private String dest;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}