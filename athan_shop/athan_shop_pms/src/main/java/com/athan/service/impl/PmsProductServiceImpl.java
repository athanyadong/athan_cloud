package com.athan.service.impl;

import com.athan.doman.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.PmsProduct;
import com.athan.service.PmsProductService;
import com.athan.mapper.PmsProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_product(商品信息)】的数据库操作Service实现
* @createDate 2022-07-22 16:53:04
*/
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct>
    implements PmsProductService{


    //根据id后去商品信息
    public PmsProduct getProduct(String id){
        return baseMapper.selectById(id);
    }

}




