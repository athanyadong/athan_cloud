package com.athan;

import com.athan.fallback.PmsProductFeignServiceBack;
import com.athan.model.rabbit.ServiceConstant;
import com.athan.util.web.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(value = ServiceConstant.ATHAN_SHOP_PMS,url = "localhost:10215/pms",path = "/user",fallback = PmsProductFeignServiceBack.class)
public interface PmsProductFeignService {
    /**
     * 获取单个商品信息
     * @param id
     * @return
     */
    @PostMapping("getProduct")
    public AjaxResult getProduct(String id);
}
