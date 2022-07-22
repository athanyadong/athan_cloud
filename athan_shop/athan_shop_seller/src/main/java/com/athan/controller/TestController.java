package com.athan.controller;

import com.athan.service.tesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "测试接口")
@RequestMapping("seller")
@RestController
@Slf4j
public class TestController {
    @Autowired
    tesService tesService;
    @ApiOperation(value = "测试哟", tags = "测试用接口")
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
