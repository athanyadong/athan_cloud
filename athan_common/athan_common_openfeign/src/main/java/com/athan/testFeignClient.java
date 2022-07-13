package com.athan;

import com.athan.fallback.testFeignClientBack;
import com.athan.model.rabbit.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service       //value的值是注册的服务名称，path地址是controller里面的前缀地址，fallback是失败的处理情况
@FeignClient(value = ServiceConstant.ATHAN_SHOP_ADMIN,path = "/test",fallback = testFeignClientBack.class,contextId = "admin1")
public interface testFeignClient {

    @GetMapping("athan")
     String test();
}
