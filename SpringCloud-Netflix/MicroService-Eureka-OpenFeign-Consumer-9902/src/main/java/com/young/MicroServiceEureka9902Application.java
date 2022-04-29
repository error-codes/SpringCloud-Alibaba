package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/27 14:26
 */
@SpringBootApplication
@EnableFeignClients
public class MicroServiceEureka9902Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka9902Application.class, args);
    }
}
