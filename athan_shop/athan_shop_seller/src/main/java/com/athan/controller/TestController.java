package com.athan.controller;

import com.athan.service.tesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @aurhor yyh
 * @description 测试信息
 * @date 2022/7/12 15:46
 */
@RequestMapping("seller")
@RestController
@Slf4j
public class TestController {
    @Autowired
    tesService tesService;
    @GetMapping("getSeller")
    public String testSeller(){
        String feign = tesService.getFeign();
        String s = feign != null ? feign : "调用失败";
        return "xiaohan"+"远程调用的结果"+s;
    }
    public void test(){
        log.info("韩某人来也");
    }

}
