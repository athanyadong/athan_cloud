package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.PmsProductLadder;
import com.athan.service.PmsProductLadderService;
import com.athan.mapper.PmsProductLadderMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_product_ladder(产品阶梯价格表(只针对同商品))】的数据库操作Service实现
* @createDate 2022-07-22 16:53:04
*/
@Service
public class PmsProductLadderServiceImpl extends ServiceImpl<PmsProductLadderMapper, PmsProductLadder>
    implements PmsProductLadderService{

}




