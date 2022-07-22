package com.athan.service.impl;

import com.alibaba.fastjson.JSON;
import com.athan.PmsProductFeignService;
import com.athan.doman.R;
import com.athan.dto.PmsProductDTO;
import com.athan.util.web.AjaxResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.OmsCartItem;
import com.athan.service.OmsCartItemService;
import com.athan.mapper.OmsCartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 返回的信息是，价钱，
 * 1,首先查看购物车的商品数量，以及商品详情
 *
 * @author Administrator
 * @description 针对表【oms_cart_item(购物车表)】的数据库操作Service实现
 * @createDate 2022-07-22 16:28:50
 */
@Service
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemMapper, OmsCartItem>
        implements OmsCartItemService {
    @Autowired
    private PmsProductFeignService pmsProductFeignService;
    //根据id查询用户购物车信息
    public R getCartItem(String memberId) {
        LambdaQueryWrapper<OmsCartItem> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<OmsCartItem> eq = queryWrapper.eq(OmsCartItem::getMemberId, memberId);

        //获取到购物车集合
        List<OmsCartItem> omsCartItems = baseMapper.selectList(eq);

        return R.ok(omsCartItems);
    }
    //添加单个商品   需要订单信息
    public R saveCartItem(OmsCartItem cartItem){
        //远程调用订单信息
        AjaxResult product = pmsProductFeignService.getProduct(cartItem.getProductId().toString());
        Object data = product.get("data");
        String s = JSON.toJSONString(data);
        PmsProductDTO pmsProductDTO = JSON.parseObject(s, PmsProductDTO.class);

        int insert = baseMapper.insert(cartItem);
        if (insert>0){
            R.ok();
        }
        return R.fail();
    }

}




