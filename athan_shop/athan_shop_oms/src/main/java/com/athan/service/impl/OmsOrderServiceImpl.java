package com.athan.service.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.athan.doman.R;
import com.athan.dto.OmsOrderDTO;
import com.athan.util.SnowFlake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.OmsOrder;
import com.athan.service.OmsOrderService;
import com.athan.mapper.OmsOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【oms_order(订单表)】的数据库操作Service实现
 * @createDate 2022-07-22 16:28:50
 */
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder>
        implements OmsOrderService {

    @Autowired
    OmsOrderMapper orderMapper; //订单管理

    //订单分类筛选(状态选项，如果不传那就是查询全部)
    public R getClassifyOrderInfo(Integer status) {
        List<OmsOrder> omsOrders = null;
        if (status == null) {
            omsOrders = baseMapper.selectList(null);
        } else {
            LambdaQueryWrapper<OmsOrder> queryWrapper = new LambdaQueryWrapper();
            LambdaQueryWrapper<OmsOrder> eq = queryWrapper.eq(OmsOrder::getStatus, status);
            omsOrders = baseMapper.selectList(eq);
        }
        return R.ok(omsOrders);
    }

    //订单查询--> 根据条件查询，

    public R getOrderList(OmsOrderDTO dto) {

        List<OmsOrder> orderList = orderMapper.getOrderList(dto);
//
//        LambdaQueryWrapper<OmsOrder> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        LambdaQueryWrapper<OmsOrder> eq = lambdaQueryWrapper.eq(OmsOrder::getOrderSn, dto.getOrderSn()).eq(OmsOrder::getReceiverName, dto.getReceiverName()).eq(OmsOrder::getPaymentTime, dto.getPaymentTime());
//        List<OmsOrder> omsOrders = baseMapper.selectList(eq);

        return R.ok(orderList);
    }
    //添加单条订单    库存-付款-
    public R saveOrder(OmsOrder omsOrder){
        //获取到订单单号
        long orderId = SnowFlake.getOrderId();
        omsOrder.setOrderSn(String.valueOf(orderId));
        int insert = baseMapper.insert(omsOrder);
        if (insert>0){
            return R.ok();
        }
        return R.fail();
    }






}




