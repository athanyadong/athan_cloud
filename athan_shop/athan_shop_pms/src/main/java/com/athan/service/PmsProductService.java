package com.athan.service;

import com.athan.model.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【pms_product(商品信息)】的数据库操作Service
* @createDate 2022-07-22 16:53:04
*/
public interface PmsProductService extends IService<PmsProduct> {

    PmsProduct getProduct(String id);
}
