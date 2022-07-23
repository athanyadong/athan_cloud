package com.athan.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @aurhor yyh
 * @description 订单查询接收类
 * @date 2022/7/23 9:36
 */
@Data
public class OmsOrderDTO implements Serializable {
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 收货人
     */
    private String receiverName;
    /**
     * 支付时间
     */
    private Date paymentTime;
    /**
     * 开始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;
}
