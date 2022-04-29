package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 15:29
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceEureka8801Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka8801Application.class, args);
    }
}
