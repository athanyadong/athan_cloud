package com.athan;

import com.athan.doman.R;
import com.athan.fallback.SysUserServiceBack;
import com.athan.model.rabbit.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Service
@FeignClient(value = ServiceConstant.ATHAN_SHOP_ADMIN,url = "localhost:10215/admin",path = "/user",fallback = SysUserServiceBack.class,contextId = "admin2")
public interface SysUserService {


    @PostMapping("/getUserInfo/{username}")
    public R selectUserByUserName(@PathVariable("username") String username);
}
