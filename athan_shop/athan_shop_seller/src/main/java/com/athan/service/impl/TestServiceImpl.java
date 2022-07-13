package com.athan.service.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.athan.service.tesService;
import com.athan.testFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/12 15:48
 */
@Service
public class TestServiceImpl implements tesService {

    @Autowired
    testFeignClient client;

    public String getFeign(){
        return client.test();
    }


}
