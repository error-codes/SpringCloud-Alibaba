package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 17:48
 */
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceEureka8003Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka8003Application.class, args);
    }
}
