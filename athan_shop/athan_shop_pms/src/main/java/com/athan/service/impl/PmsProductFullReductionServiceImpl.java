package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.PmsProductFullReduction;
import com.athan.service.PmsProductFullReductionService;
import com.athan.mapper.PmsProductFullReductionMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_product_full_reduction(产品满减表(只针对同商品))】的数据库操作Service实现
* @createDate 2022-07-22 16:53:04
*/
@Service
public class PmsProductFullReductionServiceImpl extends ServiceImpl<PmsProductFullReductionMapper, PmsProductFullReduction>
    implements PmsProductFullReductionService{

}




