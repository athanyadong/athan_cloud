package com.athan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AthanGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthanGatewayApplication.class, args);
    }

}
