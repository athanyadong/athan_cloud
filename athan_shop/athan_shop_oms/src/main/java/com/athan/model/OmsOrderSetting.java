package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 订单设置表
 * @TableName oms_order_setting
 */
@TableName(value ="oms_order_setting")
@Data
public class OmsOrderSetting implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    private Integer flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    private Integer commentOvertime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}