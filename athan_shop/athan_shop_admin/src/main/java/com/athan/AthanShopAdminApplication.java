package com.athan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.athan.mapper") //扫描Xml文件
@EnableFeignClients
public class AthanShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthanShopAdminApplication.class, args);
    }

}
