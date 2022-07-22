package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 公司收发货地址表
 * @TableName oms_company_address
 */
@TableName(value ="oms_company_address")
@Data
public class OmsCompanyAddress implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 地址名称
     */
    private String addressName;

    /**
     * 默认发货地址：0->否；1->是
     */
    private Integer sendStatus;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    private Integer receiveStatus;

    /**
     * 收发货人姓名
     */
    private String name;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 省/直辖市
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    private String detailAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}