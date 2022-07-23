package com.athan.mapper;

import com.athan.dto.OmsOrderDTO;
import com.athan.model.OmsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【oms_order(订单表)】的数据库操作Mapper
* @createDate 2022-07-22 16:28:50
* @Entity com.athan.model.OmsOrder
*/
public interface OmsOrderMapper extends BaseMapper<OmsOrder> {


    public List<OmsOrder> getOrderList(OmsOrderDTO dto);
}




