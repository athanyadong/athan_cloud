package com.athan.controller;

import com.athan.model.PmsProduct;
import com.athan.service.PmsProductService;
import com.athan.util.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/22 18:21
 */
@RestController
@RequestMapping("product")
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;

    @PostMapping("getProduct")
    public AjaxResult getProduct(String id){
        PmsProduct product = pmsProductService.getProduct(id);
        if (product!=null){
            return AjaxResult.success(product);
        }
        return AjaxResult.error("获取失败");
    }
}
