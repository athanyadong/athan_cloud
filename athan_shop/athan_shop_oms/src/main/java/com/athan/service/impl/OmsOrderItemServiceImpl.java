package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.OmsOrderItem;
import com.athan.service.OmsOrderItemService;
import com.athan.mapper.OmsOrderItemMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【oms_order_item(订单中所包含的商品)】的数据库操作Service实现
* @createDate 2022-07-22 16:28:50
*/
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem>
    implements OmsOrderItemService{

}




