package com.athan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AthanShopPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthanShopPmsApplication.class, args);
    }

}
