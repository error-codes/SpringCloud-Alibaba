package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/24 17:50
 */

@EnableEurekaServer
@SpringBootApplication
public class MicroServiceEureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka7002Application.class, args);
    }
}
