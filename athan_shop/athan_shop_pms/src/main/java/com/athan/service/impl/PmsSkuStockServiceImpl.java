package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.PmsSkuStock;
import com.athan.service.PmsSkuStockService;
import com.athan.mapper.PmsSkuStockMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_sku_stock(sku的库存)】的数据库操作Service实现
* @createDate 2022-07-22 16:53:04
*/
@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock>
    implements PmsSkuStockService{

}




