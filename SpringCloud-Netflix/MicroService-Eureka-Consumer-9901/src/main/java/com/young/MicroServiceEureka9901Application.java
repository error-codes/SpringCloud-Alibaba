package com.young;

import com.young.config.YoungConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/4/25 17:48
 */
@EnableEurekaClient
@SpringBootApplication
@LoadBalancerClient(name = "MicroService-Eureka-Provider", configuration = YoungConfig.class)
public class MicroServiceEureka9901Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka9901Application.class, args);
    }

}
