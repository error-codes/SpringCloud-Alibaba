package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 10:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroServiceNacos6602Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceNacos6602Application.class, args);
    }
}
