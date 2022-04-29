package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/28 18:04
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceEureka9527Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka9527Application.class, args);
    }
}
