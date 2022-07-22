package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.OmsOrder;
import com.athan.service.OmsOrderService;
import com.athan.mapper.OmsOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【oms_order(订单表)】的数据库操作Service实现
* @createDate 2022-07-22 16:28:50
*/
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder>
    implements OmsOrderService{

}




