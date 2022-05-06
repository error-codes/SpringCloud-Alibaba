package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/5 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceNacos5501SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceNacos5501SentinelApplication.class, args);
    }
}
