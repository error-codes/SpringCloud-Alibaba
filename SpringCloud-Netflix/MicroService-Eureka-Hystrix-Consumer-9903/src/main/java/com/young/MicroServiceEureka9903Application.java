package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 17:48
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class MicroServiceEureka9903Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka9903Application.class, args);
    }

}
